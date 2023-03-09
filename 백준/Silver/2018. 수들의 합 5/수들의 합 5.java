import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = i + 1;
		}
		
		int end = 0;
		int internalSum = 0;
		int answer = 0;
				
		for (int start = 0; start < num.length; start++) {
			while (end < N && internalSum < N) {
				internalSum += num[end];
				end++;
			}

			if (internalSum == N) {
				answer += 1;
			}
			
			internalSum -= num[start];
		}
		
		System.out.println(answer);
	}

}
