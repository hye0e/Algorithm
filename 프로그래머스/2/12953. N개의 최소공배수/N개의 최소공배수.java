import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = Integer.MAX_VALUE;
        
        int[] visited = new int[100000001];
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j < 100000001; j++) {
                if (j % arr[i] == 0) visited[j]++;
            }
        }
        
        for (int j = 0; j < 100000001; j++) {
            if (visited[j] == arr.length) {
                answer = Math.min(j, answer);
            }
        }
        
        return answer;
    }
}