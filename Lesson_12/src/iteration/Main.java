package iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        // Iterable ve Iterator

        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(6);
        Node<Integer> node3 = new Node<>(8);
        Node<Integer> node4 = new Node<>(-7);
        Node<Integer> node5 = new Node<>(9);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

//        NodeIterator iterator = new NodeIterator(node1);

        Iterator<Integer> iterator = node1.iterator();

        int i =0;
        while (iterator.hasNext()) {
            if (i == 2) iterator.remove();
            
            System.out.println(iterator.next());
            i++;

        }

    }


}
