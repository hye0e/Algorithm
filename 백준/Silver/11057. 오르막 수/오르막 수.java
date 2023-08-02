import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int len = 2; len <= N; len++) {
            // N 자리수: 2
            for (int num = 0; num <= 9; num++) {
                // 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
                for (int prev = 0; prev <= num; prev++) {
                    // 오르막 수
                    dp[len][num] += dp[len - 1][prev];
                    dp[len][num] = dp[len][num] % 10007;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dp[N][i];
        }

        System.out.println(ans % 10007);
    }

}
