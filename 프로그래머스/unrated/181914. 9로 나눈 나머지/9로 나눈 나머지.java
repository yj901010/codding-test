import java.math.BigInteger;

class Solution {
    public int solution(String number) {
        int sum = 0;
        for (char c : number.toCharArray()) {
            sum += Character.getNumericValue(c); // 각 자리 숫자를 더함
        }
        int remainder = sum % 9; // 각 자리 숫자의 합을 9로 나눈 나머지를 구함
        return remainder;
    }
}