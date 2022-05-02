package activities;

import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("D");
        hs.add("E");
        hs.add("F");
        hs.add("G");

        System.out.println("Size of HashSet: " + hs.size());
        System.out.println("Removing A from HashSet: " + hs.remove("A"));
        if(hs.remove("I")) {
            System.out.println("I removed from the Set");
        } else {
            System.out.println("I is not present in the Set");
        }

        System.out.println("Checking if C is present: " + hs.contains("C"));
        System.out.println("Updated HashSet: " + hs);
    }


}
