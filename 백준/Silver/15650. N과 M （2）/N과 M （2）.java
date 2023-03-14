import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] numbers;
	static boolean[] isSelected;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		isSelected = new boolean[N + 1];
		dfs(0, 1);
		System.out.println(sb);
	}
	
	private static void dfs(int cnt, int startIndex) {
		if (cnt == M) {
			for (int num: numbers) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		for (int i = startIndex; i <= N; i++) {
			if (isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			dfs(cnt+1, i+1);
			isSelected[i] = false;
		}
	}

}
