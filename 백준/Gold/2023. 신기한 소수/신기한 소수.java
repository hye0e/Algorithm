import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		dfs(2, 1);
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
//		System.out.println(isPrime(5));
	
	}
	
	public static boolean isPrime(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
	
	public static void dfs(int num, int temp) {	
		if (temp == N) {
			if (!isPrime(num)) return;
			System.out.println(num);
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (i % 2 == 0) continue;
			int tempNum = Integer.parseInt(String.valueOf(num) + String.valueOf(i)); 
			if (!isPrime(tempNum)) continue;
			dfs(tempNum, temp+1);
		}
	}

}
