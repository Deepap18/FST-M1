package activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args) {
        HashMap<Integer,String> hs_map = new HashMap<Integer,String>();
        hs_map.put(1,"Orange");
        hs_map.put(2,"Red");
        hs_map.put(3,"Green");
        hs_map.put(4,"Blue");
        hs_map.put(5,"Black");

        System.out.println("Original Hashmap values : "+hs_map);
        hs_map.remove(1);
        System.out.println("After removing 1st value : "+hs_map);
        if(hs_map.containsValue("Green")) {
            System.out.println("Green exists in the Map");
        } else {
            System.out.println("Green does not exist in the Map");
        }
        System.out.println("Number of pairs in the Map is: " + hs_map.size());
    }
}
