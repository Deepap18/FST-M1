package activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane{

        private List<String> passengers;
        private int maxPassengers;
        private Date lastTimeTookOf;
        private Date lastTimeLanded;

    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        passengers = new ArrayList<>();
    }
        public void onboard(String passengername){
            passengers.add(passengername);
        }

        public Date takeOff(){
            lastTimeTookOf = new Date();

            return lastTimeTookOf;
        }

        public void land(){
            lastTimeLanded = new Date();
            passengers.clear();
        }

        public Date getLastTimeLanded(){
            return lastTimeLanded;
        }

    public List<String> getPassesngers(){
        return passengers;
    }
}

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("abc");
        plane.onboard("def");
        plane.onboard("ghi");
        plane.onboard("jkl");

        System.out.println("Plane take off time : " +plane.takeOff());
        System.out.println("List of onboarding passengers : " +plane.getPassesngers());

        Thread.sleep(5000);

        plane.land();
        System.out.println("Time plane landed : " +plane.getLastTimeLanded());
    }
}
