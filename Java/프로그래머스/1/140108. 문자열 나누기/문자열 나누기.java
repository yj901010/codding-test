class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = s.charAt(0);
        int same = 0;
        int different = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (same == 0) {
                x = s.charAt(i);
            }
            
            if (s.charAt(i) == x) {
                same++;
            } else {
                different++;
            }
            
            if (same == different) {
                answer++;
                same = 0;
                different = 0;
            }
        }
        
        if (same > 0) {
            answer++;
        }
        
        return answer;
    }
}