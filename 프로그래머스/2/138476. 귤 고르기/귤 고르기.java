import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            int key = tangerine[i];
            tangerineMap.put(key, tangerineMap.getOrDefault(key, 0) + 1);
        }
        
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(tangerineMap.entrySet());
        entryList.sort(
            Map.Entry.<Integer, Integer>comparingByValue().reversed()
        );
        
        
       int answer = 0;
       int sum = 0;

        for (Map.Entry<Integer, Integer> entry : entryList) {
            sum += entry.getValue();
            answer++;
            if (sum >= k) break;
        }
        
        return answer;
    }
}