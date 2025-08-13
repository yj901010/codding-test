import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Long[] arr = new Long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int l = 0, r = N - 1, ansL = 0, ansR = N - 1;
        long best = Long.MAX_VALUE;

        while (l < r) {
            long sum = arr[l] + arr[r];
            long abs = Math.abs(sum);
            if (abs < best) { best = abs; ansL = l; ansR = r; if (abs == 0) break; }
            if (sum > 0) r--; else l++;
        }
        System.out.println(arr[ansL] + " " + arr[ansR]);
    }
}