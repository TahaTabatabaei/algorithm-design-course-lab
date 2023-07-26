import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int nums[] = new int[7];
        for (int i = 6; i >= 0; i--) {
            nums[i] = num%10;
            num -= nums[i];
            num /=10;
        }
//        for (int i = 0; i < 7; i++) {
//            System.out.println(nums[i]);
//        }
//        char[] inputChars = new char[7];
//        for (int j = 0; j < 7; j++) {
//            inputChars[j] = st.charAt(j);
//        }

//        ArrayList<HashMap<Integer, Character>> dic = new ArrayList<>();
//
//        for (int i = 2; i <= 9; i++) {
//            dic.add(i,new HashMap<Integer,Character>(3));
//        }
        char[][] chars = new char[10][3];

        chars[2][0] = 'A';
        chars[2][1] = 'B';
        chars[2][2] = 'C';

        chars[3][0] = 'D';
        chars[3][1] = 'E';
        chars[3][2] = 'F';

        chars[4][0] = 'G';
        chars[4][1] = 'H';
        chars[4][2] = 'I';

        chars[5][0] = 'J';
        chars[5][1] = 'K';
        chars[5][2] = 'L';

        chars[6][0] = 'M';
        chars[6][1] = 'N';
        chars[6][2] = 'O';

        chars[7][0] = 'P';
        chars[7][1] = 'R';
        chars[7][2] = 'S';

        chars[8][0] = 'T';
        chars[8][1] = 'U';
        chars[8][2] = 'V';

        chars[9][0] = 'W';
        chars[9][1] = 'X';
        chars[9][2] = 'Y';

       // Character u = dic.get('2').put(1,'A');

//        dic.get('2').put(1,'A');
//        dic.get('2').put(2,'B');
//        dic.get('2').put(3,'C');
//
//        dic.get('3').put(1,'D');
//        dic.get('3').put(2,'E');
//        dic.get('3').put(3,'F');
//
//        dic.get('4').put(1,'G');
//        dic.get('4').put(2,'H');
//        dic.get('4').put(3,'I');
//
//        dic.get('5').put(1,'J');
//        dic.get('5').put(2,'K');
//        dic.get('5').put(3,'L');
//
//        dic.get('6').put(1,'M');
//        dic.get('6').put(2,'N');
//        dic.get('6').put(3,'O');
//
//        dic.get('7').put(1,'P');
//        dic.get('7').put(2,'R');
//        dic.get('7').put(3,'S');
//
//        dic.get('8').put(1,'T');
//        dic.get('8').put(2,'U');
//        dic.get('8').put(3,'V');
//
//        dic.get('9').put(1,'X');
//        dic.get('9').put(2,'Y');
//        dic.get('9').put(3,'Z');

        StringBuilder sb = new StringBuilder(7);
        String str;
        int count=0;

        int x = 0;
        for (int i = 0; i < 3; i++) {
            sb.append(chars[nums[x]][i]);
            for (int j = 0; j < 3; j++) {
                sb.append(chars[nums[x+1]][j]);
                for (int k = 0; k < 3; k++) {
                    sb.append(chars[nums[x+2]][k]);
                    for (int l = 0; l < 3; l++) {
                        sb.append(chars[nums[x+3]][l]);
                        for (int m = 0; m < 3; m++) {
                            sb.append(chars[nums[x+4]][m]);
                            for (int n = 0; n < 3; n++) {
                                sb.append(chars[nums[x+5]][n]);
                                for (int o = 0; o < 3; o++) {
                                    sb.append(chars[nums[x+6]][o]);
                                    str = sb.toString();
                                    System.out.println(str);
                                    sb.deleteCharAt(6);
                                    count++;
                                }
                                sb.delete(5,6);
                            }
                            sb.delete(4,6);
                        }
                        sb.delete(3,6);
                    }
                    sb.delete(2,6);
                }
                sb.delete(1,6);
            }
            sb.delete(0,6);
        }
    }
}
