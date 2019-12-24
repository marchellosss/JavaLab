package Main;

public class ConvertInfo {
    public static void ConvertInfo(){

    }

    public static String convertToBinary(int number){
        StringBuffer buffer = new StringBuffer();

        while(number != 0){
            buffer.append(Integer.toString(number % 2));

            number = number / 2;
        }

        buffer.reverse();

        return buffer.toString();
    }

    public static String convertToOctal(int number){
        StringBuffer hex = new StringBuffer();

        do{
            int temp = number%8;
            hex = hex.append(temp);
            number = number / 8;
        } while (number > 8);

        hex = hex.append(number);
        hex.reverse();

        return hex.toString();
    }

    public static String convertToHexadecimal(int number){
        String digits = "0123456789ABCDEF";
        char[] ArrayDigits = digits.toCharArray();
        StringBuffer hex = new StringBuffer();

        do{
            int temp = number%16;
            hex = hex.append(ArrayDigits[temp]);
            number = number / 16;
        } while (number > 16);

        hex = hex.append(ArrayDigits[number]);
        hex.reverse();

        return hex.toString();
    }
}
