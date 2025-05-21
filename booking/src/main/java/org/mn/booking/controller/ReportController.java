package org.mn.booking.controller;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.mn.booking.service.ExcelService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ExcelService excelService;

    @GetMapping("/users")
    public ResponseEntity<Resource> downloadUserReport() throws IOException {
        ByteArrayInputStream in = excelService.exportUsers();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(new InputStreamResource(in));
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcel(@RequestParam MultipartFile file) {
        try {
            excelService.importUsersFromExcel(file);
            return ResponseEntity.ok("Import successful!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Import failed: " + e.getMessage());
        }
    }


}
