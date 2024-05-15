import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int max = 0;

        for(int i=1;i<=N && i<=M;i++){
            if(N%i==0 && M%i==0){
                max = i;
            }
        }

        int min = (N*M)/max;

        System.out.println(max);
        System.out.println(min);
    }
}