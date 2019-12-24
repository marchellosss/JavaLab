import java.lang.reflect.Field;
import java.util.Scanner;
import java.util.logging.Logger;

public class ReflectionClass {
    private static final Logger LOGGER = Logger.getLogger(ReflectionClass.class.getSimpleName());
    public static void main(String[] args) throws Exception {

        LOGGER.info("Program started");
        startReflection();
        LOGGER.info("Program finished");
    }
    public static String exchangeString(String str1,String str2){

        char[] chars1 = str1.toCharArray();
        char[] chars2= str2.toCharArray();
        for(int i = 0; i < chars2.length; i++ ){
            chars1[i] = chars2[i];
        }
        return String.valueOf(chars1);
    }
    public static void reflection(String secondArg) throws Exception {
        PrivateFinalFields pf = new PrivateFinalFields();
        Field f ;
        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        System.out.println("Old value:   " + pf.s2);
        f.set(pf,exchangeString(pf.s2,secondArg));
        System.out.println("New value:   " + pf);
    }
    public static void startReflection() throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your choise: ");
        String name = in.nextLine();
        String secondArg = "Java don`t love me ";
        switch (name) {
            case  ("1"):
                reflection(secondArg);
                startReflection();
            case ("2")://input 9+ values
                System.out.print("Enter word to exchange");
                name = in.nextLine();
                reflection(name);
                startReflection();
            case ("0"):
                break;
        }
    }
}
class PrivateFinalFields {
    String s2 = "I love java so much";
    public String toString() {
        return s2;
    }
}
