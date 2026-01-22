import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        Arrays.sort(A);
        Arrays.sort(B);
        
        int N = A.length;
        for (int i = 0; i < N; i++) {
            int temp = N - i - 1;
            answer += A[i] * B[temp];
        }

        return answer;
    }
}