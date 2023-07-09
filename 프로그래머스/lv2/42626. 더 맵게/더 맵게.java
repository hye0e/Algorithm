import java.util.*;
class Solution {
    static List<Integer> foods = new ArrayList<>();
    static int K;
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        while (!pq.isEmpty()) {
            int food1 = pq.poll();
            // int food2 = pq.poll();
            
            if (food1 < K) {
                if (pq.peek() != null) {
                    int food2 = pq.poll();
                    int mixed = food1 + (food2 * 2);
                    pq.add(mixed);
                    answer++;
                }
                
            } else {
                return answer;
            }

        }
        return -1;
    }
}