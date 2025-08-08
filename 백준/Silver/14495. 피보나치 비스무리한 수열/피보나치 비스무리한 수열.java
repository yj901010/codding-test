import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if (N < 4 ) {
            System.out.println(1);
            return;
        }
        arr = new long[N+1];
        arr[1] = arr[2] = arr[3] = 1;
        for (int i=4;i<=N;i++) {
            arr[i] = arr[i-3] + arr[i-1];
        }
        System.out.println(arr[N]);
    }

}
