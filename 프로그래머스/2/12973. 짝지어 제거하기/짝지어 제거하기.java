import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        
        Stack<Character> stack = new Stack();
        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
            } else {
                char temp = stack.peek();
                if (temp == arr[i]) {
                    stack.pop();
                } else {
                    stack.push(arr[i]);
                }
            }
        }
        if (stack.isEmpty()) answer = 1;
        return answer;
    }
}