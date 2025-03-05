package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

//        String[] array = {"B", "C", "A", "Z", "D", "F", "E"};
//
//        System.out.println(Arrays.toString(array));
//
//        Arrays.sort(array, String.CASE_INSENSITIVE_ORDER);
//
//        System.out.println(Arrays.toString(array));

        List<User> users = Arrays
                .asList(new User("Sahil", 15),
                        new User("Telman", 15),
                        new User("Gunduz", 14));

        System.out.println(users);

        MyComparator comparator = new MyComparator();

//        Collections.sort(users, Comparator
//                .comparing(User::getAge)
//                .thenComparing(User::getName).reversed());

        Collections.sort(users, comparator.reversed());

        System.out.println(users);
    }


}
