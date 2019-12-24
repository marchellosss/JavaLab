package Main;

public class Matrix {

    public Matrix() {

    }

    public static void reverseMatrix(int[][] array, int sizeA){
        for (int i = 0; i < sizeA; i++)
        {
            for(int j = i+1; j <sizeA; j++){
                int a = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = a;
            }
        }

        for (int i = 0; i < sizeA; ++i){
            for (int j = 0; j < sizeA/2; ++j){
                int a = array[sizeA-j-1][i];
                array[sizeA-j-1][i] = array[j][i];
                array[j][i] = a;
            }
        }
        System.out.println();

        for (int i = 0; i < sizeA; i++){
            for (int j = 0; j < sizeA; j++){
                System.out.print(array[i][j] + "    ");
            }
            System.out.println();
        }
    }
}
