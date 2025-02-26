package az.example.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.text.DateFormatter;

public class Main {

    //https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
    public static void main(String[] args) throws ParseException {

        Date date = new Date();
        System.out.println("Date: " +date);
        LocalDate localDate = LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println("LocalDate : " +localDate);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
        System.out.println("LocalDateTime: " + localDateTime);

        String datePattern = "dd.MM.yy";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(datePattern);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(datePattern);

        String formattedDate = simpleDateFormat.format(date);

        String formattedLocalDateTime = formatter.format(localDateTime);
        String formattedLocalDate = formatter.format(localDate);
        System.out.println("dd.MM.yy: " + formattedDate);
        System.out.println("dd.MM.yy: " + formattedLocalDate);
        System.out.println("dd.MM.yy: " + formattedLocalDateTime);

//        String dateStr = "a13/02/2024";
//
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
//
//        Date parsed = simpleDateFormat1.parse(dateStr);
//
//        System.out.println("Parsed Date: " + parsed);


//        LocalDate before = LocalDate.now().minus(5, ChronoUnit.DAYS); // 1
//        LocalDate after = LocalDate.now(); // 2
//
//        Period period = Period.between(before, after);
//
//        System.out.println(period.getDays());
//        System.out.println(period.getYears());
//        System.out.println(period.getMonths());


        Date before = Date.from(Instant.now().minus(15, ChronoUnit.HOURS));
        Date after = new Date();

        long diff = after.getTime() - before.getTime();

        long hours = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);

        System.out.println("Hours diff: " + hours);


    }


}
