import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int count = 0;

        for (int money : d) {
            if (budget >= money) {
                budget -= money;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}