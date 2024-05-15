import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int[] in = new int[10];
        int[] out = new int[10];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stay = 0;
        int max = 0;

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            out[i] = Integer.parseInt(st.nextToken());
            in[i] = Integer.parseInt(st.nextToken());

            stay += in[i];
            stay -= out[i];

            if (max < stay) {
                max = stay;
            }
        }

        System.out.print(max);
    }

}
