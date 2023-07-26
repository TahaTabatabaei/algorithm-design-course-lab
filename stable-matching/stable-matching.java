import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        int  t = scanner.nextInt();

        System.out.println();
        int[][] priority = new int[1][1];
        for (int i = 1; i <= t; i++) {
          int  n = scanner.nextInt();

            priority = new int[2 * n][2 * n];


            for (int j = 0; j < (2 * n); j++) {
                int[] priorityq = new int[n];
                for (int k = 0; k < n; k++) {
                    priorityq[k] = scanner.nextInt();
                }
                priority[j] = priorityq;
            }

//            for (int u=0; u< priority.length; u++) {
//                for ( int j=0;j < priority[u].length ; j++){
//                    System.out.println("prefer["+u+"]["+j+"] = " + priority[u][j]);
//                }
//                System.out.println();
//            }

            System.out.println();
            System.out.println("#" + i);
            matching(priority, n);
            System.out.println();


        }
    }
    /*    static int[] getPriority ( int n){
            Scanner scanner = new Scanner(System.in);
            int[] priorityq = new int[n];

            //  StringTokenizer stringTokenizer = new StringTokenizer(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                //   if(stringTokenizer.hasMoreTokens())

                priorityq[i] =
                        scanner.nextInt();
                //   Integer.parseInt(stringTokenizer.nextToken());

            }
            return priorityq;
        }*/

        static boolean isShePrefer ( int[][] priority, int w, int m, int fiance, int n){
        //    System.out.println("fight between "+(m+1)+" and "+(fiance+1));
            for (int i = 0; i < n; i++) {

        //        System.out.println("round: "+ i );
                if (priority[(w+n)][i] == (fiance+1)) {
         //           System.out.println(" w"+ (w+1) +" does not prefer new guy m"+ (m+1) +" over fiance "+ (fiance+1));
                    return false;
                }
                if (priority[(w+n)][i] == (m+1)) {
         //           System.out.println("w"+ (w+1) +" prefer m"+ (m+1) +" over fiance "+ (fiance+1));
                    return true;
                }
            }
         //   System.out.println("w"+ (w+1)+" prefer m"+ (m+1));
            return true;
        }

        static void matching ( int[][] priority, int n){

            //System.out.println("matching");
            boolean[] freeMenList = new boolean[n];
            boolean[] freeWomenList = new boolean[n];
            for (int i = 0; i < n; i++) {
                freeWomenList[i] = true;
                freeMenList[i] = true;
            }

            int[] fiances = new int[n];

            int m = 0, w = 0;
            int k = n;
            while (k > 0) {

                for (int j = 0; j < n; j++) {
                    if (freeMenList[j] == true) {
                        m = j;
             //           System.out.println(" man "+ (m+1) +" is free");
                        break;
                    }
                }

                if (freeMenList[m] == false)
                    break;

                for (int j = 0; j < n; j++) {
                    w = priority[m][j] - 1;

                    if (freeWomenList[w] == true) {
                        fiances[w] = m;
                 //       System.out.println("women "+ (w+1)+" is free so happy engagement");
                        freeMenList[m] = false;
                        freeWomenList[w] = false;
                        k--;
                        break;
                    }

                    int fiance = fiances[w];

                    if (isShePrefer(priority, w, m, fiance, n) == true) {
                        fiances[w] = m;
                  //      System.out.println("w"+ (w+1)+" cheated on man "+ (fiance+1)+" for man "+ (m+1));
                        freeMenList[m] = false;
                        freeMenList[fiance] = true;
                        break;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                int o = fiances[i];
                o++;
                System.out.print(o + " ");
            }



        }
    }