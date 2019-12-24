package Main;

public class BeautifulNumber {
    private int  number;
    public BeautifulNumber( int number) {

        this.number = number;
    }

    public boolean isBeautiful(){
        boolean check = false;

        if(notNull()) {
            int arrayCount = 0;
            int sum = 0;
            int[] array = new int[this.number];

            for (int i = 1; i < number; i++) {
                if (this.number % i == 0) {
                    array[arrayCount] = i;
                    arrayCount++;
                }
            }

            for (int i = 0; i < arrayCount; i++) {
                sum += array[i];
            }

            if (this.number == sum) {
                check = true;
            }
        }
        else {
            System.out.println("Incorrect number");
        }

        return check;
    }

    private boolean notNull(){
        if(this.number==0){
            return false;
        }
        else return true;
    }
}
