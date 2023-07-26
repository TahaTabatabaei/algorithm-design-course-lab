import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int inversion(int[] A,int left, int right){
        int x1 = 0,x2 = 0,x3 = 0;
        if (left < right) {
            int mid = ((left + right) / 2);

            x1 = inversion(A, left, mid);
            x2 = inversion(A, mid + 1, right);

            x3 = inversionMerge(A, left, mid, right);

        }
        return (x1 + x2 + x3);
    }

    static int inversionMerge(int[] A,int left,int mid, int right){
//
        int[] B = new int[(right-left)+1];
        int i = left, j = mid+1, k = 0, counter = 0;

        while (i<= mid && j<= right){
            if(A[i] <= A[j]){
                B[k++] = A[i++];
                counter += (j-mid)-1;
            }else {
                B[k++] = A[j++];
            }
        }

        while (i <= mid){
            B[k++] = A[i++];
            counter += right-mid;
        }
        while (j <= right){
            B[k++] = A[j++];
        }
        for (k = 0; k <= (right-left); k++) {
            A[left+k] = B[k];
        }
        return counter;
    }




    public static void main(String[] args) {

        // write your code here
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        ArrayList<String> result = new ArrayList();

        do {
            n = scanner.nextInt();
            if (n == 0){
                break;
            }

            int[] list = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = scanner.nextInt();
            }

            int counter = 0;
            counter = inversion(list,0,n-1);
          //  System.out.println("counter = " + counter);

            counter = counter%2;
            if (counter == 0){
                result.add("Aghdas");
            }else {
                result.add("Morteza");
            }

        }while (true);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
//    int counter = 0;
//
//        int[] leftA = Arrays.copyOfRange(A, left, mid + 1);
//        int[] rightA = Arrays.copyOfRange(A, mid + 1, right + 1);
//
//        int i = 0, j = 0, k = left;
//
//        while (i < leftA.length && j < rightA.length) {
//            if (leftA[i] <= rightA[j])
//                A[k++] = leftA[i++];
//            else {
//                A[k++] = rightA[j++];
//                counter += (mid + 1) - (left + i);
//            }
//        }
//        while (i < leftA.length)
//            A[k++] = leftA[i++];
//        while (j < rightA.length)
//            A[k++] = rightA[j++];