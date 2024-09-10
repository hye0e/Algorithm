import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 숫자가 큰 녀석부터 없애야함 -> Collection reverseOrder PQ 사용
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int priority : priorities) {
            pQ.add(priority);
        }
        
        while(!pQ.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pQ.peek()) {
                    pQ.poll();
                    answer++;
                    if (i == location) return answer;
                }
            }
        }
        System.out.println(pQ);
        return answer;
    }
}