import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[][] A;
    static int[][] minDP, maxDP;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new String[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) A[i][j] = st.nextToken();
        }

        minDP = new int[N][N];
        maxDP = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(minDP[i], INF);
            Arrays.fill(maxDP[i], -INF);
        }

        int start = Integer.parseInt(A[0][0]);
        minDP[0][0] = maxDP[0][0] = start;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if ((i + j) % 2 == 1) {
                    if (i > 0 && (i - 1 + j) % 2 == 0) {
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i - 1][j]);
                        minDP[i][j] = Math.min(minDP[i][j], maxDP[i - 1][j]);
                        maxDP[i][j] = Math.max(maxDP[i][j], minDP[i - 1][j]);
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i - 1][j]);
                    }
                    if (j > 0 && (i + j - 1) % 2 == 0) {
                        minDP[i][j] = Math.min(minDP[i][j], minDP[i][j - 1]);
                        minDP[i][j] = Math.min(minDP[i][j], maxDP[i][j - 1]);
                        maxDP[i][j] = Math.max(maxDP[i][j], minDP[i][j - 1]);
                        maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][j - 1]);
                    }
                } else {
                    if (i == 0 && j == 0) continue;

                    int num = Integer.parseInt(A[i][j]);

                    if (i > 0 && (i - 1 + j) % 2 == 1 && (minDP[i - 1][j] != INF || maxDP[i - 1][j] != -INF)) {
                        String op = A[i - 1][j];
                        int c1 = apply(maxDP[i - 1][j], num, op);
                        int c2 = apply(minDP[i - 1][j], num, op);
                        minDP[i][j] = Math.min(minDP[i][j], Math.min(c1, c2));
                        maxDP[i][j] = Math.max(maxDP[i][j], Math.max(c1, c2));
                    }

                    if (j > 0 && (i + j - 1) % 2 == 1 && (minDP[i][j - 1] != INF || maxDP[i][j - 1] != -INF)) {
                        String op = A[i][j - 1];
                        int c1 = apply(maxDP[i][j - 1], num, op);
                        int c2 = apply(minDP[i][j - 1], num, op);
                        minDP[i][j] = Math.min(minDP[i][j], Math.min(c1, c2));
                        maxDP[i][j] = Math.max(maxDP[i][j], Math.max(c1, c2));
                    }
                }
            }
        }

        System.out.println(maxDP[N - 1][N - 1] + " " + minDP[N - 1][N - 1]);
    }

    static int apply(int x, int y, String op) {
        switch (op) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            default:  return x; 
        }
    }
}
