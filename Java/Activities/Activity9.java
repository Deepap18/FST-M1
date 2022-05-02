package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<String>();
        myList.add("square");
        myList.add("cylinder");
        myList.add("Sphere");
        myList.add("Circle");
        myList.add("rectangle");

        for(String shapes:myList){
            System.out.println(shapes);
        }

        System.out.println("Third element of the array : " + myList.get(3));
        System.out.println("Is Circle is in list: " + myList.contains("Circle"));
        System.out.println("Size of ArrayList: " + myList.size());

        myList.remove("Sphere");
        System.out.println("Size of ArrayList: " + myList.size());
    }

}
