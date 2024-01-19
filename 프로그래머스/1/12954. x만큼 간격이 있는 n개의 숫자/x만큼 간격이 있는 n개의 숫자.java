class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        int idx = 0;
        for(long i=1;i<=n;i++){
            answer[idx] = x * i;
            idx++;
        }
        return answer;
    }
}