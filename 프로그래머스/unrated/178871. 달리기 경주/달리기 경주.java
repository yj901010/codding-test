import java.util.HashMap;
import java.util.Map;

class Solution {
       
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> t_player = new HashMap<String, Integer>();
        
        for(int i=0;i<players.length;i++){
            t_player.put(players[i],i);
        }
        for(String player : callings){
            
            int idx = t_player.get(player);
            String before = players[idx-1];
            
            players[idx-1] = player;
            players[idx] = before;
            
            t_player.put(player, idx-1);
            t_player.put(before, idx);
        }
        
        return players;
    }
}