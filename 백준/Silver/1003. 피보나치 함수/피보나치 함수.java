import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[][] dp = new int[2][41];

            dp[0][0] = 1;
            dp[0][1] = 0;

            dp[1][0] = 0;
            dp[1][1] = 1;

            for (int i = 2; i <= N; i++) {
                dp[0][i] = dp[0][i - 1] + dp[0][i - 2];
                dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
            }
            sb.append(dp[0][N] + " " + dp[1][N]).append("\n");
        }
        System.out.println(sb);
    }
}
