import java.util.*;
class Solution {

    public int solution(int[] diffs, int[] times, long limit) {
        int maxLevel = Arrays.stream(diffs).max().getAsInt();
        int minLevel = 0;

        while (true) {
            int middleLevel = (maxLevel + minLevel) / 2;

            long total = calculateTotal(diffs, times, middleLevel);

            if (limit < total) {
                minLevel = middleLevel;
            } else {
                maxLevel = middleLevel;
            }

            if (maxLevel - minLevel <= 1) {
                break;
            }
        }

        return maxLevel;
    }

    private long calculateTotal(int[] diffs, int[] times, int level) {
        long total = calculateTimePerPuzzle(diffs[0], times[0], 0, level);

        for (int i = 1; i < diffs.length; i++) {
            total += calculateTimePerPuzzle(
                    diffs[i],
                    times[i],
                    times[i - 1],
                    level
            );
        }

        return total;
    }

    private long calculateTimePerPuzzle(int diff, int timeCur, int timePrev, int level) {
        if (diff > level) {
            return (long) (diff - level) * (timeCur + timePrev) + timeCur;
        }

        return timeCur;
    }
}