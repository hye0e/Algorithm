import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int M = triangle.length;
        int[][] dp = new int[M][M];

        // 초기값
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < M; i++) {
            // 처음
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            for (int j = 1; j < i; j++) {
//                System.out.println(i + " " + j);
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
            // 끝
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        Arrays.sort(dp[M - 1]);

        return dp[M - 1][M - 1];
    }
}