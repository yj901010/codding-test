import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        Set<String> list = new HashSet<>();
        int N = Integer.parseInt(st1.nextToken());
        String M = st1.nextToken();

        for(int i =0;i<N;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            list.add(st2.nextToken());
        }
        switch (M) {
            case "Y":
                System.out.println(list.size());
                break;
            case "F":
                System.out.println(list.size()/2);
                break;
            case "O":
                System.out.println(list.size()/3);
                break;
        }
    }
}
