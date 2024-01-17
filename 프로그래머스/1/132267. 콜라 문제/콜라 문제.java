class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int remain = 0;
        while(true){
            
            if(n >= a){
                answer += n/a*b;
                remain = n%a + (n/a)*b;
                n = remain;
            }else{
                break;
            }
        }
        return answer;
    }
}