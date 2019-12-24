package Main;

public class Main {
    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
    }

    public static void taskOne() {
        int number = 90;

        ConvertInfo con = new ConvertInfo();
        System.out.println("Binary: " + con.convertToBinary(number));
        System.out.println("Octal: " + con.convertToOctal(number));
        System.out.println("Hex: " + con.convertToHexadecimal(number));
    }

    public static void taskTwo(){
        BeautifulNumber object = new BeautifulNumber(7);

        if (object.isBeautiful()){
            System.out.println("Number is beautiful!");
        }else{
            System.out.println("Number is not beautiful!");
        }
    }

    public static void taskThree(){
        PiramidaHeopsa piramida = new PiramidaHeopsa(7);
        piramida.build_pyramid();
    }

    public static void taskFour(){
        int sizeA = 4;

        int[][] array = new int[sizeA][sizeA];

        for(int i = 0; i < sizeA; i++){
            for(int j = 0; j < sizeA; j++){
                array[i][j] = (int) (Math.random() * 100);
                System.out.print(array[i][j] + "    ");
            }
            System.out.println();
        }

        Matrix a = new Matrix();
        a.reverseMatrix(array, sizeA);

    }


}


