import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int minCit = citations[0];
        int maxCit = citations[citations.length - 1];
        int answer = 0;

        for (int i = 0; i <= maxCit; i++) {
            int h = i;
            int cnt = 0;
            int restCnt = 0;
                        
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= h) {
                    cnt++;
                } else {
                    restCnt++;
                }
            }
            System.out.println(h);
            if (cnt >= h && restCnt <= h) {
                answer = Math.max(h, answer);
            }
        }
        return answer;
    }
}