import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        ArrayList<String> list = new ArrayList<>();
        
        int len = cards1.length + cards2.length;
        
        ArrayList<String> card1 = new ArrayList<>();
        ArrayList<String> card2 = new ArrayList<>();
        
        for(int i=0;i<cards1.length;i++){
            card1.add(cards1[i]);
        }
        for(int i=0;i<cards2.length;i++){
            card2.add(cards2[i]);
        }
        for(int i=0;i<goal.length;i++){
                if(!card1.isEmpty() &&  goal[i].equals(card1.get(0))){
                    card1.remove(0);
                }else if(!card2.isEmpty() &&  goal[i].equals(card2.get(0))){
                    card2.remove(0);
                }else{
                    answer = "No";
                    break;
                }
            }
        
        
        return answer;
    }
}