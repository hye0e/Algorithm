import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] arr;
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp = new int[K + 1];
		dp[0] = 1;
		for (int i = 0; i < N; i++) { // 1 2 3
			for (int j = arr[i]; j <= K; j++) {
				dp[j] = dp[j] + dp[j - arr[i]];
			}
		}
		
		System.out.println(dp[K]);
	}

}
