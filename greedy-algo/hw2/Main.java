import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] puzzles = new int[m];
        for (int i = 0 ; i<m ; i++){
             puzzles[i] = scanner.nextInt();
        }
        System.out.println(func(n,puzzles,m));
    }

    public static int func(int n,int[] puzzles,int m){
        int minSum =0;
        Arrays.sort(puzzles);
        minSum = puzzles[n-1] - puzzles[0];
        for (int j=1;j <= m-n;j++){
            int diff = puzzles[j+(n-1)] - puzzles[j];

            if (diff<minSum){
                minSum = diff;
            }
        }

        return minSum;
    }
}
