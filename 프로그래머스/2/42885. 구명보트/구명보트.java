import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 50 50 70 80
        
        Arrays.sort(people);
        
        for (int i = 0; i < people.length; i++) {
            for (int j = i + 1; j < people.length; j++) {
                if (people[i] == 0) continue;
                if (people[i] + people[j] <= limit) {
                    people[i] = 0;
                    people[j] = 0;
                    answer++;
                    System.out.println("?");
                }
            }
        }
        
        for (int i = 0; i < people.length; i++) {
            if (people[i] != 0) answer++;
        }
        return answer;
    }
}