import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int sum = Integer.MAX_VALUE;
        // 1, 2, 4 / 4,4,5
        // 1*5 2*4 4*4 = 5 + 8 + 16 = 29
        
        // 1, 2 / 3, 4
        // 1*4 + 2
        Integer[] b2 = new Integer[B.length];
        for (int i = 0; i < B.length; i++) {
            b2[i] = new Integer(B[i]);
        }
        Arrays.sort(A);
        Arrays.sort(b2, Collections.reverseOrder());
        // 0, 1, 2
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * b2[i];
        }
        
        return answer;
    }
}