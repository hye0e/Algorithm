import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}
	
	private static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return false; 
		}
		return true;
	}
	
	private static void dfs(int num, int cnt) {
		if (cnt == N) {
			if (isPrime(num)) {
				System.out.println(num);
			}
			
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (i % 2 == 0) continue;
			
			if (isPrime(num * 10 + i)) {
				dfs(num * 10 + i, cnt+1);
			}
		}
	}

}
