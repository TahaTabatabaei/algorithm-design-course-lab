import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();

        memory = new int[n+1][3][n+1];
        scanner.close();

        System.out.println(piece(n,0));
    }

    static int[][][] memory;
    static int a, b, c;


    static int piece(int n , int counter){
        if (n < 0){
            return -1;
        }else if(n == 0){
            return counter;
        }

        if(memory[n][0][counter] == 0){
            memory[n][0][counter] = piece(n - a , counter+1);
        }
        if(memory[n][1][counter] == 0){
            memory[n][1][counter] = piece(n - b , counter+1);
        }
        if(memory[n][2][counter] == 0){
            memory[n][2][counter] = piece(n - c , counter+1);
        }

        return max(max(memory[n][0][counter],memory[n][1][counter]),memory[n][2][counter]);
    }

    static int max(int a , int b){
        if(a > b)
            return a;
        else
            return b;
    }
}
