import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i<= t;i++){
            int n = scanner.nextInt();
            int x = scanner.nextInt();

            int[] a=new int[n],b=new int[n];

            for (int j = 0;j<n;j++){
                a[j] = scanner.nextInt();
            }
            for (int j =0;j<n;j++){
                b[j] = scanner.nextInt();
            }
            //System.out.println();
            if(func(a,b,x)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }

        }
    }

    public static boolean func(int[] a, int[] b, int x){

        Arrays.sort(a);
        Arrays.sort(b);
        int j = (b.length-1);
        for (int i=0;i<a.length;i++){
            int sum = a[i] + b[j];
            if(sum > x){
                return false;
            }
            j--;
        }
        return true;
    }
}
