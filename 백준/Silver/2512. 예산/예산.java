import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int ans;
    static int M;

    public static int budget(int[] arr,int low, int high) {
        int mid = (low + high) / 2;
        int sum = 0;
        for(int i=0;i<arr.length;i++) {
            if (arr[i] > mid) sum += mid;
            else sum += arr[i];
        }
        if(low > high) {
            return high;
        }
        if (sum > M) {
            high = mid - 1;
        } else {
            low = mid + 1;
        }
        return budget(arr ,low, high);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        StringTokenizer st3 = new StringTokenizer(br.readLine());
        Arrays.sort(arr);
        M = Integer.parseInt(st3.nextToken());
        int sum = IntStream.of(arr).sum();
        int max = Arrays.stream(arr).max().getAsInt();
        if (sum <= M) {
            ans = max;
        } else {
            ans = budget(arr, 0, max);
        }
        System.out.println(ans);

    }
}
