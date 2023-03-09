import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N + 1];
		int[] prefix_sum = new int[N + 1];
		
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			prefix_sum[i] = prefix_sum[i - 1] + arr[i];
		}
		
		int answer = prefix_sum[K];
		int internalSum = prefix_sum[K];

		for (int start = K; start < prefix_sum.length; start++) {
			internalSum = prefix_sum[start] - prefix_sum[start - K];
			if (internalSum > answer) {
				answer = internalSum;
			}
		}
		System.out.println(answer);
	}
}
