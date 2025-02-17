import java.util.Random;

public class ArrayMethods {


    public static void main(String[] args) {

        int[] arr = {5, 15, -20};


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


        System.out.println("==========");

        changeArrayValues(arr);


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("===================");

        int[] newArr = changeArrayValuesByReturn(arr);

        for (int i = 0; i < newArr.length; i++) {
            System.out.println(newArr[i]);
        }

    }


    public static void changeArrayValues(int[] arr) {
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

    }

    public static int[] changeArrayValuesByReturn(int[] arr) {
        Random random = new Random();

        int[] tempArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = random.nextInt(100);
        }
        return tempArr;
    }


}
