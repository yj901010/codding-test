import java.util.ArrayList;
class Solution {
    public ArrayList<Integer> solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        while(n != 1){
            list.add(n);
            if(n % 2 == 0){
                n /= 2;
            }else{
                n = 3 * n +1;
            }
        }
        list.add(1);
        
       
        return list;
    }
}