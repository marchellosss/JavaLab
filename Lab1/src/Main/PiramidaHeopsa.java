package Main;

public class PiramidaHeopsa {
    private int number;

    public PiramidaHeopsa(int number){
        this.number = number;
    }

    public void build_pyramid(){
        int a = this.number;
        for (int i = 1; i <= this.number; i++) {
            for (int j = a; j > 1; j--) {
                System.out.printf(" %s", " ");
            }

            for (int k = 1; k != i+1; k++) {
                String str1 = "" + k;
                System.out.printf(" %s", str1);
            }

            a--;

            for (int l = i-1; l >= 1; l--) {
                String str2 = "" + l;
                System.out.printf(" %s", str2);
            }

            System.out.println();
        }
    }
}
