import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>(); 
        
        for (int[] size : sizes) {
            if (size[0] <= size[1]){
                min.add(size[0]);
                max.add(size[1]);
            } else {
                min.add(size[1]);
                max.add(size[0]);
            }
        }
        answer = Collections.max(min) * Collections.max(max);
        return answer;
    }
}