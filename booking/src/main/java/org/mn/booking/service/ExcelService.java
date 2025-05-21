package org.mn.booking.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mn.booking.dto.response.UserResponseDto;
import org.mn.booking.entity.User;
import org.mn.booking.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class ExcelService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    public ByteArrayInputStream exportUsers() throws IOException {
        List<UserResponseDto> users = userService.findAll();

        return exportExcel(users, UserResponseDto.class, "user_list");
    }


    public ByteArrayInputStream exportUsersToExcel(List<User> users) throws IOException {

        if (users == null || users.isEmpty()) {
            return new ByteArrayInputStream(new byte[0]);
        }

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Users");

            // Header
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Name");
            header.createCell(2).setCellValue("Surname");
            header.createCell(3).setCellValue("Registered At");

            // Rows
            int rowIdx = 1;
            for (User user : users) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getFirstName());
                row.createCell(2).setCellValue(user.getLastName());
                row.createCell(3).setCellValue(user.getCreatedAt().toString());
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }


    public static <T> ByteArrayInputStream exportExcel(List<T> dataList,
                                                       Class<T> clazz,
                                                       String sheetName) throws IOException {

        if (dataList == null || dataList.isEmpty()) {
            return new ByteArrayInputStream(new byte[0]);
        }

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet(sheetName);

            // Header
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 14);
            headerFont.setFontName("Arial");
            headerFont.setColor(IndexedColors.GREEN.getIndex());


            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);


            Row headerRow = sheet.createRow(0);
            headerRow.setHeightInPoints(20);

            Field[] fields = clazz.getDeclaredFields();

            for (int col = 0; col < fields.length; col++) {
                sheet.setColumnWidth(col, 25 * 256); // hər sütuna 25 simvol genişlik

                fields[col].setAccessible(true);
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(fields[col].getName());
                cell.setCellStyle(headerStyle);
            }

            // Rows
            int rowIdx = 1;
            for (T item : dataList) {
                Row row = sheet.createRow(rowIdx++);
                for (int col = 0; col < fields.length; col++) {
                    fields[col].setAccessible(true);
                    Object value = fields[col].get(item);
                    Cell cell = row.createCell(col);
                    cell.setCellValue(value != null ? value.toString() : "");

                    CellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setWrapText(true);
                    cell.setCellStyle(cellStyle);

                }
            }

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Excel export error", e);
        }
    }


    @Transactional
    public void importUsersFromExcel(MultipartFile file) throws IOException {
        try (InputStream is = file.getInputStream();
             Workbook workbook = WorkbookFactory.create(is)) {

            Sheet sheet = workbook.getSheetAt(0);

            List<User> users = new ArrayList<>();

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                User user = new User();

                user.setUsername(getCellString(row.getCell(0)));
                user.setPassword(passwordEncoder.encode(getCellString(row.getCell(1))));
                user.setFirstName(getCellString(row.getCell(2)));
                user.setLastName(getCellString(row.getCell(3)));

                users.add(user);
            }

            userRepository.saveAll(users);
        }
    }

    private String getCellString(Cell cell) {
        return cell == null ? null : cell.getStringCellValue().trim();
    }

}
