package activities;

public class Activity2 {

    public static void main (String[] args){
        int[] num = {10, 77, 10, 54, -11, 10};

        int checkvalue = 10;
        int sum = 0;
        for(int n : num){

            if(n == checkvalue){
                sum += n;
            }

            else{
                System.out.println("array value not equal to 10");
            }
        }

        if(sum == 30){
            System.out.println("sum of 10's in given array " + sum);
        }
    }
}
