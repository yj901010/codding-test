class Solution {
    public int[] solution(int[] arr) {
        int len = 0;
        if(arr.length == 1 ){
            len = 1;
        }else{
            len = arr.length - 1;
        }
        int[] answer = new int[len];
        if(arr.length == 1){
            answer[0] = -1;
        }else{
            int min = arr[0];
            for(int i=0;i<arr.length;i++){
                if(arr[i] < min){
                    min = arr[i];
                }
            }
            System.out.print(min);
            int j = 0;
            for(int i=0;i<arr.length;i++){
                if(arr[i] == min){
                    continue;
                }else{
                    answer[j] = arr[i];
                    j++;
                }
            }
        }
        
        return answer;
    }
}