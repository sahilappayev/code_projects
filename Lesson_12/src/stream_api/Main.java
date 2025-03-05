package stream_api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        String[][] arr = {{"A", "B", "C"}, {"D", "E", "F"}};


//        for (String element : arr) {
//            System.out.println(element);
//        }

//        Stream.of(arr).forEach(new Main()::printWithRandomNumber);//element

//        Stream.of(arr)
//                .flatMap(Stream::of)
//                .filter(e -> checkEquality("D", e))
//                .map(Main::mapValue)
//                .forEach(new Main()::printWithRandomNumber);

        String s = null;

        Optional.ofNullable(s).ifPresent(System.out::println);

//        Stream.of(arr)
//                .forEach(element -> {
//                    Stream.of(element).filter(e -> checkEquality("D", e))
//                            .map(Main::mapValue)
//                            .forEach(new Main()::printWithRandomNumber);
//                });

//        Map<String, Integer> map = new HashMap<>();
//        map.put("A", 1);
//        map.put("B", 2);
//        map.put("C", 3);
//        map.put("D", 4);

//        map.forEach((key, value) -> {
//            System.out.println(key + " : " + value);
//        });

    }

    public static boolean checkEquality(Object arg1, Object arg2) {
        return arg1.equals(arg2);
    }

    public void printWithRandomNumber(Object value) {
        Random random = new Random();
        System.out.println(value + " " + random.nextInt(100));
    }

    public static String mapValue(Object value) {
        return value + " Mapped";
    }

}
