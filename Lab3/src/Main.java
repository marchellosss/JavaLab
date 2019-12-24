import java.util.ArrayList;
import java.util.*;
import java.util.EnumMap;
import java.util.Map;
enum Types { A, B, C }
public class Main {
    public static void main(String[] args) {
        Turnstile turnstile = new Turnstile(9,10);
        StudentPass studentPass1 = new StudentPass("Vasyl",10,25,26,9);
        StudentPass studentPass2 = new StudentPass("Eduard",30,18,1,10);
        ChildPass childPass1 = new ChildPass("Olya",10,10,1,10);
        ChildPass childPass2 = new ChildPass("Artem",30,0,1,10);
        UsualPass usualPass1 = new UsualPass("Bogdan",365,1,6,10);
        UsualPass usualPass2 = new UsualPass("Vadim",10,0,6,10,30,3);

        System.out.println("Hello! Welcome to our turnstile..");

        if(turnstile.checkAccess(childPass1))
        {
            System.out.println("Name: "+childPass1.getName());
            System.out.println("Access: allowed");
            childPass1.setTripsNumber(childPass1.getTripsNumber()-1);
            System.out.println("The rest of the trips: "+ childPass1.getTripsNumber()+"\n");

        }
        else
        {
            System.out.println("Name: "+childPass1.getName());
            System.out.println("Access: denied"+"\n");
        }

        if(turnstile.checkAccess(childPass2))
        {
            System.out.println("Name: "+childPass2.getName());
            System.out.println("Access: allowed");
            childPass2.setTripsNumber(childPass2.getTripsNumber()-1);
            System.out.println("The rest of the trips: "+ childPass2.getTripsNumber()+"\n");
        }
        else
        {
            System.out.println("Name: "+childPass2.getName());
            System.out.println("Access: denied"+"\n");
        }
/////////////////////////////////////////////////////////////////////////
        if(turnstile.checkAccess(studentPass1))
        {
            System.out.println("Name: "+studentPass1.getName());
            System.out.println("Access: allowed");
            studentPass1.setTripsNumber(studentPass1.getTripsNumber()-1);
            System.out.println("The rest of the trips: "+ studentPass1.getTripsNumber()+"\n");

        }
        else
        {
            System.out.println("Name: "+studentPass1.getName());
            System.out.println("Access: denied"+"\n");
        }

        if(turnstile.checkAccess(studentPass2))
        {
            System.out.println("Name: "+studentPass2.getName());
            System.out.println("Access: allowed");
            studentPass2.setTripsNumber(studentPass2.getTripsNumber()-1);
            System.out.println("The rest of the trips: "+ studentPass2.getTripsNumber()+"\n");
        }
        else
        {
            System.out.println("Name: "+studentPass2.getName());
            System.out.println("Access: denied"+"\n");
        }
////////////////////////////////////////////////////////////////////////////////
        if(turnstile.checkAccess(usualPass1))
        {
            System.out.println("Name: "+usualPass1.getName());
            System.out.println("Access: allowed");
            usualPass1.setTripsNumber(usualPass1.getTripsNumber()-1);
            System.out.println("The rest of the trips: "+ usualPass1.getTripsNumber()+"\n");
        }
        else
        {
            System.out.println("Name: "+usualPass1.getName());
            System.out.println("Access: denied"+"\n");
        }

        if(turnstile.checkAccess(usualPass2))
        {
            System.out.println("Name: "+usualPass2.getName());
            System.out.println("Access: allowed");
            usualPass2.setTripsNumber(usualPass2.getTripsNumber()-1);
            System.out.println("The rest of the trips: "+ usualPass2.getTripsNumber()+"\n");
        }
        else
        {
            System.out.println("Name: "+usualPass2.getName());
            System.out.println("Access: denied"+"\n");
        }

        System.out.println("General history "+turnstile.getCurrentDay()+"."+turnstile.getCurrentMonth()+" :");
        turnstile.showGeneralHistory();

        System.out.println("Student history "+turnstile.getCurrentDay()+"."+turnstile.getCurrentMonth()+" :");
        turnstile.showStudentHistory();

        System.out.println("Child history "+turnstile.getCurrentDay()+"."+turnstile.getCurrentMonth()+" :");
        turnstile.showChildHistory();

        System.out.println("Usual history "+turnstile.getCurrentDay()+"."+turnstile.getCurrentMonth()+" :");
        turnstile.showUsualHistory();

        usualPass2.setMoney(200);
        System.out.println("Name: "+usualPass2.getName());
        System.out.println("Money: "+usualPass2.getMoney());
        System.out.println("The rest of the trips:"+usualPass2.getTripsNumber()+"\n");
        System.out.println("Bye..");


    }

}
