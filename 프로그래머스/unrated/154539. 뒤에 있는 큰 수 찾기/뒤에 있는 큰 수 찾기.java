import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        // 1. 자신보다 뒤에 있는 숫자 
        // 2. 나보다 큰 숫자
        Stack<Integer> stack = new Stack<>();
        // 스택 막 숫자 or 그 전 숫자
        for (int i = numbers.length - 1; i >= 0; i--) {
            // stack.peek(); // 삭제 없이 요소 가져오기
            while (!stack.isEmpty()) {
                if (stack.peek() > numbers[i]) {
                    answer[i] = stack.peek();
                    break;
                } else {
                    stack.pop();
                }
            }
            
            if (stack.isEmpty()) {
                answer[i] = -1;
            }
            stack.push(numbers[i]);
        }
        
        return answer;
    }
}