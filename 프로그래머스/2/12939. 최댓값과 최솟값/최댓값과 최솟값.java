import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int N = st.countTokens();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            minNum = Math.min(minNum, arr[i]);
            maxNum = Math.max(maxNum, arr[i]);
        }
        
        return minNum + " " + maxNum;
    }
}