package az.example.exceptions;

public class Main {


    public static void main(String[] args)  {


        int i = 5;

        int b = 0;


        printText("Hiiiii");
        callPrint();


//        try {
////            int a = i / b;
//
//            Class<?> testClass = Class.forName("az.example.exceptions.Test"); //  throw new ClassNotFoundException();
//            System.out.println(testClass.getName());
//
//            Thread.sleep(1000);
//
//            throw new InterruptedException("Heyyyy!");
//
//        } catch (ClassNotFoundException exception) {
//            System.out.println("Catch ClassNotFoundException block worked!");
////            System.out.println("Exception class: " + exception.getClass().getName() +
////                    " message: " + exception.getMessage());
//            StackTraceElement[] stackTrace = exception.getStackTrace();
//            for (StackTraceElement stackTraceElement : stackTrace) {
//                if (stackTraceElement.getClassName().startsWith("az.example")) {
//                    System.err.println(stackTraceElement);
//                }
//            }
//
//        } catch (NullPointerException | ArithmeticException | IllegalArgumentException e) {
//
//
//            System.out.println("Catch Exception block worked!");
//            System.out.println("Exception message: " + e.getMessage());
//            System.out.println("Exception class: " + e.getClass().getName());
//            System.out.println("Exception cause: " + e.getCause());
//        } catch (Exception e) {
//            System.out.println(String
//                    .format("Catch InterruptedException block worked! Exception: %s, %s",
//                            e.getClass().getName(), e.getMessage()));
//        } finally {
//            System.out.println("Finally block worked!");
//        }
//
//
//        System.out.println("Hello World!");


    }



    public static void callPrint() {
        printText("");
    }


    public static void printText(String text)  {
        if (text == null || text.isEmpty()) {
//            throw new InvalidTextValue();
            throw new InvalidTextValue("Text cant be null or empty!!");
        }
        System.out.println(text);
    }


}
