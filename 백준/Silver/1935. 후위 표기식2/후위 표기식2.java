import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken().trim());

        String line = br.readLine().trim();
        char[] c = line.toCharArray();
        Stack<Number> stack = new Stack<>();
        double ans;

        int[] num = new int[N];
        for (int i=0;i<N;i++) {
            num[i] = Integer.parseInt(br.readLine().trim());
        }

        for(int i=0;i<c.length;i++) {
            if(c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/') {
                double b = (double) stack.pop();
                double a = (double) stack.pop();

                switch (c[i]) {
                    case '+':
                        stack.push(a+b);
                        break;
                    case '-':
                        stack.push(a-b);
                        break;
                    case '*':
                        stack.push(a*b);
                        break;
                    case '/':
                        stack.push(a/b);
                        break;
                }
            }
            else {
                int d = (int) c[i];
                stack.push((double) num[d-65]);
            }
        }
        System.out.println(String.format("%.2f", stack.pop()));
    }
}
