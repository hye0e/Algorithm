import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        while (n != 0) {
            // 홀수
            if (n % 2 != 0) {
                ans++;
                n--;
            } else {
                n -= (n / 2);
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");

        return ans;
    }
}