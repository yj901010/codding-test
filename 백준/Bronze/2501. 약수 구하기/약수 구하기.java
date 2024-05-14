import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int count = 0;

        for(int i=1;i<=N;i++){
            if(N%i == 0) count++;

            if(count == K){
                System.out.print(i);
                break;
            }
        }

        if(count < K){
            System.out.print(0);
        }
    }

}
