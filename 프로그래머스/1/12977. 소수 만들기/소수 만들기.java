class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int size = nums.length;
        
        for(int i=0;i<size;i++){
            for(int j=i+1;j<size;j++){
                for(int k=j+1;k<size;k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    
                    int check = 0;
                    
                    for(int p=2;p<sum;p++){
                        if(sum % p == 0){
                            check++;
                        }
                    }
                    if(check == 0){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
}