import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static boolean[] isSelected;
 	static int[] num;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		isSelected = new boolean[N + 1];
		num = new int[M];
		
		dfs(0);
		System.out.println(sb);
	}
	
	public static void dfs(int cnt) {
		if (cnt == M) {
			for (int i: num) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue;
			
			num[cnt] = i;
			isSelected[i] = true;
			dfs(cnt+1);
			isSelected[i] = false;
		} 
	}

}
