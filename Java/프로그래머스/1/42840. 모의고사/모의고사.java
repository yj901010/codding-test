import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] count = {0, 0, 0};

        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for (int i = 0; i < answers.length; i++) {
            if (p1[i % 5] == answers[i]) count[0]++;
            if (p2[i % 8] == answers[i]) count[1]++;   // 길이 8
            if (p3[i % 10] == answers[i]) count[2]++;  // 길이 10
        }

        int max = 0;
        for (int c : count) {
            if (c > max) {
                max = c;
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                answer.add(i + 1);
            }
        }

        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }
}