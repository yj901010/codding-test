class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int r1 = 1;
        int r2 = 0;
        
        for(int i=0;i<num_list.length;i++){
            r1 *= num_list[i];
            r2 += num_list[i]; 
        }
        r2 *= r2;
        
        if(r1 > r2) answer = 0;
        else answer = 1;
        return answer;
    }
}