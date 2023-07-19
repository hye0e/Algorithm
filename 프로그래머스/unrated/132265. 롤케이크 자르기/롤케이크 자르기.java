import java.util.HashSet;

class Solution {
    public int solution(int[] topping) {
        int answer = -1;
        // 각 조각에 동일한 가짓수의 토핑이 올라가면
        
        // 이분 탐색 후 자르기 
        // 왼쪽이 더 많으면 min = mid + 1;
        // 오른쪽이 더 많으면 max = mid - 1;
        
        // 공평한지 체크 -> hash 이용
        // 가지수 리턴
        int min = 0;
        int max = topping.length;

        while (min <= max) {
            int mid = (min + max) / 2;
            HashSet<Integer> left = new HashSet<>();
            HashSet<Integer> right = new HashSet<>();

            for (int i = 0; i < mid; i++) {
                left.add(topping[i]);
            }

            for (int i = mid; i < topping.length; i++) {
                right.add(topping[i]);
            }

            if (left.size() > right.size()) {
                min = mid + 1;
            } else if (left.size() > right.size()) {
                max = mid - 1;
            } else {
                answer++;
            }
        }
        
        return answer;
    }
}