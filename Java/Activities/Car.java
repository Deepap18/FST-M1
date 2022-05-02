package activities;

public class Car {
    String color = "red";
    String transmission = "trans";
    int make = 10;
    int tyres;
    int doors;

    Car(int a, int b) {
        tyres = a;
        doors = b;
    }

    public void displayCharacteristics() {
        System.out.println("Car Color : " + color + " , " + "transmission : " + transmission + " , " + "make : " + make + " , " + "tyres : " + tyres + " , " + "doors : " + doors);
    }

    public void accelarate() {
        System.out.println("Car is moving forward.");
    }

    public void brake() {
        System.out.println("Car has stopped.");
    }

}
