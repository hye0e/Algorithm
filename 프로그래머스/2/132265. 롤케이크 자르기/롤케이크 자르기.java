import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> rightMap = new HashMap<>();        
        // 원소 개수 100만이므로 완탐불가 -> for문 한번만 진행하도록 구현해주어야함
        for (int topp : topping) {
            rightMap.put(topp, rightMap.getOrDefault(topp, 0) + 1);
        }
        // 왼쪽에 있는 토핑 종류를 저장하는 Set
        Set<Integer> leftSet = new HashSet<>();
        for (int i = 0; i < topping.length; i++) {
            // 왼쪽으로 옮김
            leftSet.add(topping[i]);
            
            // 오른쪽 맵에서 현재 토핑의 개수를 하나 줄임
            rightMap.put(topping[i], rightMap.get(topping[i]) - 1);
            if (rightMap.get(topping[i]) == 0) {
                rightMap.remove(topping[i]);
            }
            
            // 토핑의 개수가 같다면 answer++
            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}