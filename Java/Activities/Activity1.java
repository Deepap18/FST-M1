package activities;

public class Activity1 {

    public static void main(String[] args){

        //Car car = new Car();
        Car car = new Car(4,2);
        car.displayCharacteristics();
        car.accelarate();
        car.brake();
    }
}
