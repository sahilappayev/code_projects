package collections;

import generics.Store;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Collection API
        // List
        // Map
        // Set
        // Stack
        // Queue

        // FIFO
        // select, get
        List<Integer> list = new ArrayList<>(2);
        list.add(6); // 1
        list.add(7); // 2
        list.add(-8); // 3
        list.add(0); // 4

        list.add(0,14);


//        for (Integer i : list) {
//            System.out.println(i);
//        }

//        Store<Integer, String> store = new Store<>();
//        store.addData(5);
//        store.addData(55);
//        store.addData(15);
//
//        store.addData(3, 12);
//
//        System.out.println(store);

//        List<String> strings = List.of("A", "B", "C", "D", "E", "F");
//
//        List<String> mutableStrings = new ArrayList<>(strings);
//        mutableStrings.add("A");
//        mutableStrings.add(null);
//        mutableStrings.add(null);
//
//        System.out.println(mutableStrings);


        MyLinkedList<String> linkedStrings = new MyLinkedList<>();

        linkedStrings.add("S");
        linkedStrings.add("A");
        linkedStrings.add("B");

        System.out.println(linkedStrings);


    }

}
