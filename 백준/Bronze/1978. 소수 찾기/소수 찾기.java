import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int count = 0;

        for(int i = 0; i < N; i++) {
            int tmp = in.nextInt();
            if(is_Prime(tmp)) count++;
        }
        System.out.println(count);
    }
    static boolean is_Prime(int tmp){

        if(tmp == 1) return false;

        for(int i=2;i<tmp;i++){
            if(tmp % i == 0) return false;
        }
        return true;
    }
}