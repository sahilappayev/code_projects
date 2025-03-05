package stack;

import java.util.Stack;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        // Stack - LIFO

        Stack<Integer> stack = new Stack<>();
        // size = 4
        stack.push(1); // 4 - 0
        stack.push(5); // 3 - 1
        stack.push(8); // 2 - 2
        stack.push(9); // 1 - 3 => 4- 3

        // index 3 = 6
        // 6++ => 7
        // 7++ => 8

        System.out.println(stack.lastIndexOf(4));

        System.out.println(stack);
    }


    public static void a(){
        b();
    }

    public static void b(){
        c();
    }

    public static void c(){
    }

}
