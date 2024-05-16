import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static boolean[] alpha = new boolean[26];
    static String[] words;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];
        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            tmp = tmp.replace("anta","");
            tmp = tmp.replace("tica","");
            words[i] = tmp;
        }

        if(K < 5){
            System.out.print("0");
            return;
        }else if(K==26){
            System.out.print(N);
            return;
        }

        alpha['a'-'a'] = true;
        alpha['c'-'a'] = true;
        alpha['i'-'a'] = true;
        alpha['n'-'a'] = true;
        alpha['t'-'a'] = true;

        backtracking(0, 0);
        System.out.print(max);
    }

    static void backtracking(int start, int len){
        if(len == K-5){
            int count = 0;
            for(int i=0;i<N;i++){
                boolean read = true;
                for(int j=0;j<words[i].length();j++){
                    if(!alpha[words[i].charAt(j) - 'a']){
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            max = Math.max(max,count);
            return;
        }

        for(int i=start;i<26;i++){
            if(!alpha[i]){
                alpha[i] = true;
                backtracking(i+1,len+1);
                alpha[i] = false;
            }
        }
    }
}