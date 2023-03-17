import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, answer;
	static int[] columns;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		columns = new int[N];
		
		answer = 0;
		
		queen(0);
		System.out.println(answer);
	}
	
	public static void queen(int depth) { // cnt번째 줄에 퀸 배치
		// 행을 다 채우면 카운트를 1증가 시키고 리턴 시킨다.
		if (depth == N) {
			answer++;
			return;
		}
		for (int i = 0; i < N; i++) {
			columns[depth] = i; // cnt번째 줄에 i번째 위칭 퀸 배치
			if(isAvailable(depth)) queen(depth + 1); // 다음 줄에 퀸 배치
		}
	}
	
	public static boolean isAvailable(int row) {
		for (int i = 0; i < row; i++) {
			if (columns[row] == columns[i]) return false;
			
			if(Math.abs(columns[row]-columns[i]) == Math.abs(row - i)) return false;
		}
		
		return true;
	}
}