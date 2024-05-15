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

        System.out.println(gcf(N,M));
        System.out.println(lcm(N,M));
    }
    
    static int gcf(int N, int M){
        if(N<M){
            int temp = N;
            N = M;
            M = temp;
        }
        while (M!=0){ // 유클리드 호제법
            int r = N % M;
            N = M;
            M = r;
        }
        return N;
    }
    
    static int lcm(int N, int M){
        return N*M / gcf(N,M);
    }
}