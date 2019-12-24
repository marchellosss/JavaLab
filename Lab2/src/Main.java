import java.util.Scanner;
public class Main {
    static int journalCount =0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Journal[] journals = new Journal[10];
       // піздец journals[0].setName("Sanya");

        int action = 0;

        action = startProgram(action);

        while ( action!= 3)
        {
            System.out.println(journalCount);
            action = currentAction(action, journalCount, journals);
        }

        System.out.println("Bye..");

    }
    public static  int startProgram(int action) {
        System.out.println("Hello! Choose number:\n");
        System.out.println("1. Add new student;");
        System.out.println("2. Show info;");
        System.out.println("3. Exit.");
        Scanner in = new Scanner(System.in);
        action= in.nextInt();
        return action;
    }
    public static int currentAction(int action, int journalCount, Journal[] journals){
        if(action==1){
            addStudent( journals);
            action=endProgram(action);

        }
        else{
            if(action==2) {
                showInfo(journals);
                action=endProgram(action);
            }
        }
        return action;
    }
    public static void addStudent( Journal[] journals) {
        Scanner in = new Scanner(System.in);
        String inputString;
        int inputNumber;
        int correctInput=0;

        Journal newJournal = new Journal();
        while(correctInput==0) {
            System.out.println("Input name:");
            try {
                inputString = in.next();
                newJournal.setName(inputString);
                correctInput++;
            }
            catch(Exception e){
                System.out.println("Incorrect input");
            }
        }
        correctInput=0;

        while(correctInput==0) {
            System.out.println("Input surname:");
            try {
                inputString = in.next();
                newJournal.setSurname(inputString);
                correctInput++;
            } catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }
        correctInput=0;
        while(correctInput==0) {
            System.out.println("Input birthday:");
            try {
                inputNumber = in.nextInt();
                newJournal.setBirthday(inputNumber);
                correctInput++;
            } catch (Exception e) {
                System.out.println("Incorrect input");
                in.close();
            }
        }
        correctInput=0;


        while(correctInput==0) {
            System.out.println("Input birthmonth:");
            try {
                inputNumber = in.nextInt();
                newJournal.setBirthmonth(inputNumber);
                correctInput++;
            }
            catch(Exception e)
            {
                System.out.println("Incorrect input");
            }
        }

        while(correctInput==0) {
            System.out.println("Input birthyear:");
            try {
                inputNumber = in.nextInt();
                newJournal.setBirthyear(inputNumber);
                correctInput++;
            }
            catch(Exception e) {
                System.out.println("Incorrect input");
            }
            correctInput = 0;
        }
        correctInput = 0;

        while(correctInput==0) {
            System.out.println("Input phoneNumber:");
            try {
                inputString = in.next();
                newJournal.setPhoneNumber(inputString);
                correctInput++;
            } catch (Exception e) {
                System.out.println("Incorrect input");
            }
        }
        correctInput=0;


        while(correctInput==0) {

            System.out.println("Input streetName:");
            try {
                inputString = in.next();
                newJournal.setStreetName(inputString);
                correctInput++;
            }
            catch(Exception e) {
                System.out.println("Incorrect input");
            }
        }
        correctInput=0;


        while(correctInput==0) {
            System.out.println("Input houseNumber:");
            try{
            inputNumber = in.nextInt();
            newJournal.setHouseNumber(inputNumber);
            correctInput++;
            }
            catch(Exception e) {
                System.out.println("Incorrect input");
            }
        }
        correctInput=0;


        while(correctInput==0) {
            System.out.println("Input apartmentNumber:");
            inputNumber = in.nextInt();
            try {
                newJournal.setApartmentNumber(inputNumber);
                correctInput++;
            }
            catch(Exception e) {
                System.out.println("Incorrect input");
            }
        }
        correctInput=0;

        journals[journalCount]= newJournal;
        journalCount++;

    }
    public static void showInfo(Journal[] journals){
        if(journalCount==0){
            System.out.println("Journal is empty");
        }
        else{
            for ( int i = 0; i < journalCount; i++)
            {
                System.out.println("Student "+i+"\n");
                System.out.println("Name: "+journals[i].getName());
                System.out.println("Surname: "+journals[i].getSurname());
                System.out.println("Date of birth: "+journals[i].getBirthday()+"."+journals[i].getBirthmonth()+"."+journals[i].getBirthyear());
                System.out.println("Phone number: "+journals[i].getPhoneNumber());
                System.out.println("Address: "+journals[i].getStreetName()+" street, house "+journals[i].getHouseNumber()+", apartment "+journals[i].getApartmentNumber()+"\n");

            }
        }
    }
    public static  int endProgram( int action) {
        System.out.println("Are you here? Choose number: \n");
        System.out.println("1. Add new student;");
        System.out.println("2. Show info;");
        System.out.println("3. Exit.");
        Scanner in = new Scanner(System.in);
        action = in.nextInt();
        return action;
    }

}
