import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st1.nextToken());
        int MAX = 30;
        long[][] dp = new long[MAX+1][MAX+1];
        for (int i = 0; i <= MAX; i++) {
            dp[i][0] = dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        for(int i=0;i<T;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st2.nextToken());
            int M = Integer.parseInt(st2.nextToken());

            System.out.println(dp[M][N]);
        }
    }
}
