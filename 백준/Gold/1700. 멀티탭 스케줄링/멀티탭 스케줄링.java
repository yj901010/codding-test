import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] name = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            name[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] use = new boolean[101];
        int put = 0;
        int cnt = 0;
        for(int i=0;i<K;i++){
            int tmp = name[i];

            if(!use[tmp]){
                if(put < N){
                    use[tmp] = true;
                    put++;
                }else{
                    ArrayList<Integer> arr = new ArrayList<>();
                    for(int j=i;j<K;j++){
                        if(use[name[j]] && !arr.contains(name[j])){
                            arr.add(name[j]);
                        }
                    }

                    if(arr.size() != N){
                        for(int j=0;j<use.length;j++){
                            if(use[j] && !arr.contains(j)){
                                use[j] = false;
                                break;
                            }
                        }
                    }else{
                        int remove = arr.get(arr.size()-1);
                        use[remove] = false;
                    }
                    use[tmp] = true;
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}