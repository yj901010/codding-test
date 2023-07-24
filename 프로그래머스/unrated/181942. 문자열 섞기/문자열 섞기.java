class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        int cnt = 0;
        int cnt1 = 0;
        for(int i=1;i<=(str1+str2).length();i++){
            if(i%2 == 1){
                answer += str1.charAt(cnt);
                cnt++;
            }else{
                answer += str2.charAt(cnt1);
                cnt1++;
            }
        }
        return answer;
    }
}