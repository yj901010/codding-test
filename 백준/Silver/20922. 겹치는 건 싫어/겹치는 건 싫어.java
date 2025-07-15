import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());

        int[] arr = new int[N];
        int max = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
            max = Math.max(max, arr[i]);
        }

        int[] tmp = new int[max+1];
        int ans = 0;

        int left = 0;
        int right = 0;

        while( right < N ) {
            while(right < N && tmp[arr[right]] + 1 <= K) {
                tmp[arr[right]]++;
                right++;
            }
            ans = Math.max(ans, right-left);
            tmp[arr[left]]--;
            left++;
        }

        System.out.println(ans);

    }
}
