import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> stack = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            int rest = (100 - progresses[i]) % speeds[i];
            if (rest != 0) day++;
            stack.add(day);
        }
                
        List<Integer> dayList = new ArrayList<>();

        int work1 = stack.poll();
        int cnt = 1;
        while (!stack.isEmpty()) {
            int work2 = stack.peek();

            if (work1 >= work2) {
                cnt++;
                stack.poll();
            } else {
                dayList.add(cnt); // cnt 더한 것을 먼저 넣어줌 
                cnt = 1; // cnt 초기화
                work1 = stack.poll();
            }
        }
        dayList.add(cnt);
        int[] answer = new int[dayList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = dayList.get(i);
        }
        
        return answer;
        
        // / 10 / 1 / 1 / 20 / 1
        
        // 1. stack 에 남은 기간들을 넣고
        // 뒤에것보다 앞의 것이 더 크면 pop 갯수
        
    }
}