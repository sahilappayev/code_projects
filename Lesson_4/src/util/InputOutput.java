package util;

import java.util.Scanner;

public class InputOutput {

    public static void printText(String message) {
        System.out.println(message);
    }

    public static void printErrorText(String message) {
        System.err.println(message);
    }

    public static String getUserTextInput(String message) {
        Scanner scanner = new Scanner(System.in);
        printText(message);
        return scanner.nextLine();
    }

    public static int getUserIntInput(String message) {
        Scanner scanner = new Scanner(System.in);
        printText(message);
        return scanner.nextInt();
    }

}
