package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {

        // eqauls ve hashcode convention
        // HashMap -> null - key, null -> value
        // LinkedHashMap -> siralamani temin edir
        // ConcurrentHashMap -> multiThread, no null value
        // TreeMap -> no null -> key, valuelari sort edir
        Map<String, Number> map = new TreeMap<>();



        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 1);
        map.put("E", 5);
        map.put("E", -345);

        map.put("E", null);

//        map.put(null, 5); // null
        map.put("null", 1);  // 1

        // E -> 2
        // B -> 1
        Set<String> set = new HashSet<>();

        System.out.println("MAP: " + map);
        System.out.println("SET: " + set);

        set.add("Z");
        set.add("A");
        set.add("T");

        System.out.println("SET: " + set);

        //bucket 0 - -> node -> node
        // bucket 1 -> node -> node -> node
        // bucket 2 -> node -> node -> node -> node
        //bucket 16 -> node -> node







    }


}
