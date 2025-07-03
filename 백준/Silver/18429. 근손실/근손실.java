import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static boolean[] visit;
    static int N;
    static int K;
    static int ans;

    public static void dfs(int row, int sum) {
        if (row == N) {
            ans++;
            return;
        }

        for(int i=0;i<N;i++) {
            if (!visit[i]) {
                if (sum + arr[i] >= 0) {
                    visit[i] = true;
                    dfs(row+1, sum+arr[i]);
                    visit[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken()) - K;
        }

        ans = 0;
        dfs(0,0);
        System.out.println(ans);
    }
}
