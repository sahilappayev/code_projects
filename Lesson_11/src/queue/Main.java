package queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Main {


    public static void main(String[] args) {
        // Queue - > FIFI
        /*
        * offer() metodunun avantajı, kuyruğa öğe eklerken istisna (exception)
        *  fırlatmak yerine sadece false döndürmesidir. Bu, kuyruk kapasitesine ulaşması gibi
        *  durumlarda programın çökmesini engeller.
        *
        * */



        Queue<String> queue = new PriorityQueue<>(5);

        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");

        System.out.println(queue.poll());

        System.out.println(queue);

        // A -> B - > C -> D ......... -> Z
        // A <- B <- C <-D .......... <-Z
    }


}
