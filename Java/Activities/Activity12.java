package activities;

interface FunctionInterfaceExample{
    int Add(int x,int y);
}

public class Activity12 {

    public static void main(String[] args){


        // following lambda expression
        FunctionInterfaceExample ad1 = (a,b) -> (a + b);
        System.out.println(ad1.Add(10,20));
        // lambda function

        FunctionInterfaceExample ad2 = (int a, int b) -> {
            return(a + b);
        };
        System.out.println(ad2.Add(100,200));
    }
}
