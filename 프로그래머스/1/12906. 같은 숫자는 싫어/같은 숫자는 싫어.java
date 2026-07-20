import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();
        
        for (int n : arr) {
            if (answer.isEmpty() || answer.get(answer.size() - 1) != n) {
                answer.add(n);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}