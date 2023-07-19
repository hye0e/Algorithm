import java.util.*;

class Solution {
    public static int solution(int[] topping) {
        int answer = 0;
        // 각 조각에 동일한 가짓수의 토핑이 올라가면
        Map<Integer, Integer> map1 = new HashMap<>(); // 형
        Map<Integer, Integer> map2 = new HashMap<>(); // 동생

        for (int e: topping) {
            // toping이 몇개 들어갔는지
            map2.put(e, map2.getOrDefault(e, 0) + 1);
        }

        for (int e: topping) {
            map1.put(e, map1.getOrDefault(e, 0) + 1);

            if (map2.get(e) - 1 == 0) {
                map2.remove(e);
            } else {
                map2.put(e, map2.get(e) - 1);
            }

            if (map1.size() == map2.size()) answer++;
        }
        return answer;
    }
}