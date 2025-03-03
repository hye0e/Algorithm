import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int scv : scoville) pq.add(scv);
        
        // 임시 스코빌 지수
        int tempK = 0;

        while (pq.peek() < K) {
            answer++;
            
            try {
                int scv1 = pq.poll();
                int scv2 = pq.poll();
                
                tempK = scv1 + scv2 * 2; 
            } catch (NullPointerException e) {
                return -1;
            }
            
            pq.add(tempK);
        }
        
        return answer;
    }
}