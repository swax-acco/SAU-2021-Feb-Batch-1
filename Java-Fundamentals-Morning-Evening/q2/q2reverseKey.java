package q2;

import java.util.*;

public class q2reverseKey {  
     public static void main(String args[]) {
        TreeMap <String, String> treeMap = new TreeMap <String, String> ();

        treeMap.put("key2", "value1");
        treeMap.put("key1", "value2");
        treeMap.put("key4", "value3");
        treeMap.put("key3", "value4");

        System.out.println("TreeMap content: " + treeMap);
        System.out.println("Reverse order view of the keys: " + treeMap.descendingKeySet());
    }
}