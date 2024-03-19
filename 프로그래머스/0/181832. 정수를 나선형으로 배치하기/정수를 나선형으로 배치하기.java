class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int x = 0;
        int y = 0;
        int num = 1;
        
        for(int i=n;i>0;i-=2){
            
            for(int j=0;j<i;j++){
                answer[x][y] = num;
                num++;
                y++;
            }
            x++;
            y--;
            for(int j=0;j<i-1;j++){
                answer[x][y] = num;
                num++;
                x++;
            }
            x--;
            y--;
            for(int j=0;j<i-1;j++){
                answer[x][y] = num;
                num++;
                y--;
            }
            x--;
            y++;
            for(int j=0;j<i-2;j++){
                answer[x][y] = num;
                num++;
                x--;
            }
            y++;
            x++;
        }
        
        return answer;
    }
}