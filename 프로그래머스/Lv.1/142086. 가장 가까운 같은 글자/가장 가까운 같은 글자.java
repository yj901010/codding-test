class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i=0;i<s.length();i++){
            if(s.indexOf(s.charAt(i)) != i){
                int idx = s.lastIndexOf(s.charAt(i),i-1);
                answer[i] = i-idx;
            }else{
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}