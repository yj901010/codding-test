import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int student : lost) {
            lostSet.add(student);
        }

        for (int student : reserve) {
            reserveSet.add(student);
        }

        Set<Integer> overlap = new HashSet<>(lostSet);
        overlap.retainAll(reserveSet);

        lostSet.removeAll(overlap);
        reserveSet.removeAll(overlap);

        List<Integer> sortedReserve = new ArrayList<>(reserveSet);
        Collections.sort(sortedReserve);

        for (int student : sortedReserve) {
            if (lostSet.contains(student - 1)) {
                lostSet.remove(student - 1);
            } else if (lostSet.contains(student + 1)) {
                lostSet.remove(student + 1);
            }
        }

        return n - lostSet.size();
    }
}