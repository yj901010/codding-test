import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int[][] ans;
    static boolean[] visited;
    static int N;

    public static void dfs(int start, int node) {
        for (int i = 0; i < N; i++) {
            if (arr[node][i] == 1 && !visited[i]) {
                visited[i] = true;
                ans[start][i] = 1;
                dfs(start, i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        ans = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
