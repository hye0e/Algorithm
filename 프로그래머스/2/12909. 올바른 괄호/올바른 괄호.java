import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack stack = new Stack<>();
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        if (s.charAt(0) == ')' || s.length() % 2 != 0 || s.charAt(s.length() - 1) == '(') {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }
            
            if (!stack.isEmpty() && s.charAt(i) == ')') {
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}