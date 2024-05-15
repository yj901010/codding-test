import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] A = new int[10];
            for(int j=0;j<10;j++){
                A[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            answer[i] = A[7];
        }
        for(int i=0;i<N;i++){
            System.out.println(answer[i]);
        }
    }
}