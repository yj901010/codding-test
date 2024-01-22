class Solution {
    public long solution(long n) {
        long answer = 0;
        answer = (long)Math.sqrt(n);
        
        if(n == Math.pow(answer,2)){
            return (long)Math.pow(answer+1,2);    
        }else{
            return -1;
        }
        
    }
}