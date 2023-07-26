import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int visitedToken = 1;

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[m+1][m+1];

        for (int i =1 ; i <= m ; i++){
            for (int j = 1 ; j<= m ; j++){
                matrix[i][j] = 0;
            }
        }

        for (int i = 1 ; i <=m ; i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int c = scanner.nextInt();
            matrix[u][v] = c;
            matrix[v][u] = c;
        }

        int n = ford(s,t,matrix);
        System.out.println(n);
    }

    static int ford(int s , int t , int[][] matrix){
        int n = matrix.length;
        int[] visited = new int[n];

        for (int maxFlow = 0; ; ) {


            int flow = dfs(matrix, visited, s, t, Integer.MAX_VALUE);
            visitedToken++;

            maxFlow += flow;
            if (flow == 0) {

                return maxFlow;
            }
        }
    }

    static int dfs(int[][] matrix, int[] visited, int node, int sink, int flow){

        if (node == sink) return flow;

        int[] cap = matrix[node];
        visited[node] = visitedToken;

        for (int i = 0; i < cap.length; i++) {
            if (visited[i] != visitedToken && cap[i] > 0) {

                if (cap[i] < flow) flow = cap[i];
                int dfsFlow = dfs(matrix, visited, i, sink, flow);

                if (dfsFlow > 0) {
                    matrix[node][i] -= dfsFlow;
                    matrix[i][node] += dfsFlow;
                    return dfsFlow;
                }
            }
        }

        return 0;
    }


}
