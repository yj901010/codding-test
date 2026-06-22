import java.util.*;

class Solution {
    public String solution(String s) {
        Character[] arr = new Character[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}