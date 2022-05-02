package activities;

interface BicycleParts{
    public int gears = 0;
    public int speed = 0;
}

interface BicycleOperations{
    public void applyBrake(int decrement);
    public void speedUp(int increment);

}

class Bicycle implements BicycleParts,BicycleOperations{
    public int gears;
    public int speed;
    Bicycle(int gears,int speed){
        this.gears = gears;
        this.speed = speed;
    }

    public void applyBrake(int decrement){
        speed = speed-decrement;
        System.out.println("Speed after decrement : "+speed);
    }
    public void speedUp(int increment){
        speed = speed + increment;
        System.out.println("Speed after increment : "+speed);
    }
    public String bicycleDesc() {
        return("No of gears : "+ gears + "\nSpeed of bicycle is : " + speed);
    }
}

class MountainBike extends Bicycle{
    public int seatHeight;

    MountainBike(int gears, int speed, int seatHeight) {
        super(gears, speed);
        this.seatHeight = seatHeight;
    }

    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    public String bicycleDesc() {
        return(super.bicycleDesc() + "\nseatHeight of bicycle is : " + seatHeight);
    }
}
public class Activity7 {

    public static void main(String args[]) {
        MountainBike mb = new MountainBike(3, 0, 25);
        System.out.println(mb.bicycleDesc());
        mb.speedUp(20);
        mb.applyBrake(5);
    }
}
