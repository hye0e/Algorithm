import java.util.*;

class Solution {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static int[] run = new int[]{1, 2};
    
    public long solution(int n) {
        long[] answer = new long[2001];
        answer[1] = 1;
        answer[2] = 2;
        
        for (int i = 3; i < answer.length; i++){
            answer[i] = (answer[i - 1] + answer[i - 2]) % 1234567;
        }
        return answer[n];
    }
}