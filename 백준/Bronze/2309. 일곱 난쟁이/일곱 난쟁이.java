import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] list = new int[9];
        int sum = 0;

        for(int i=0;i<9;i++){
            list[i] = Integer.parseInt(br.readLine());
            sum += list[i];
        }
        for(int i=0;i<8;i++){
            for(int j=i+1;j<9;j++){
                if(sum - list[i] - list[j] == 100){
                    list[i] = 0;
                    list[j] = 0;
                    Arrays.sort(list);
                    for(int k=2;k<9;k++){
                        System.out.println(list[k]);
                    }
                    return;
                }
            }
        }

    }
}