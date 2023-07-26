import java.util.Scanner;

public class Main {

    static int visitedToken =1;

    public static void main(String[] args) {
	// write your code here
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[] mArray = new int[m];
        int[][] graph = new int[m+n+2][m+n+2];
        int[] nGraph = new int[n];

        int counter = 0;
        for (int i =0; i< m ; i++){
            mArray[i] = scanner.nextInt();
            counter += mArray[i];
        }
        for (int j = 0 ; j<n ;j++){
            nGraph[j] = scanner.nextInt();
        }

        for (int i =1; i<m+1 ; i++){
            for (int j = m+1; j<m+n+1 ;j++){
                graph[i][j] = 1;
            }
        }

        for (int i= 1; i<m+1; i++){
            graph[0][i] = mArray[i-1];
            graph[i][0] = 0;
        }
        for (int j = m+1 ; j< m+n+1 ; j++ ){
            graph[m+n+1][j] = 0;
            graph[j][m+n+1] = nGraph[j-m-1];
        }

        int x = ford(0,m+n+1,graph);
        if (counter == x)
            System.out.println(1);
        else
            System.out.println(0);
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
