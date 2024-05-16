import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<W;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i=1;i<W-1;i++){
            int left_heigt = 0;
            int right_heigt = 0;
            for(int j=0;j<i;j++){
                left_heigt = Math.max(arr[j], left_heigt);
            }

            for(int j=i+1;j<W;j++){
                right_heigt = Math.max(arr[j], right_heigt);
            }

            if(arr[i] < left_heigt && arr[i] < right_heigt){
                result += Math.min(left_heigt,right_heigt) - arr[i];
            }
        }
        System.out.print(result);
    }
}