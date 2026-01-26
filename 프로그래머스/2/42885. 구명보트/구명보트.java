import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int answer = 0;

        while (left <= right) {
            answer++; // 보트 1대는 무조건 사용 (right는 항상 탑승)

            if (people[left] + people[right] <= limit) {
                left++; // 가벼운 사람도 같이 태울 수 있으면 태움
            }
            right--; // 무거운 사람은 항상 처리
        }
        
        return answer;
    }
}
