import java.util.Scanner;

public class Main {

    static int t = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0 ; i < n ; i++){
            a[i] = scanner.nextInt();
        }


        quiz(0,0,a);

        System.out.println(t);
    }

    static void quiz(int p , int r , int[] a ){


//            System.out.println(" quiz with " + p +" and "+ r + " :");
//            System.out.println("t = " + t);

            int j;
            for (j = 0; j < a.length-1; j++) {
                if (2 * a[j] < a[j + 1]) {
//                    System.out.println("return t ("+ t +") for " + p + ", " + r );
                    if( t <= (r-p)+1){
                        t = (r-p)+1;
                    }
                    p = j+1;
                    r = p;
                }else {
                    r = j + 1;
                }
            }
            if( t <= (r-p)+1 ){
                t = (r-p)+1;
            }
    }
}
