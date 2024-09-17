import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }
        
        List<Integer> sortList = new ArrayList<>(map.keySet());
        sortList.sort((o1, o2) -> map.get(o2) - map.get(o1));
       
        for (int key : sortList) {
            k -= map.get(key);
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}