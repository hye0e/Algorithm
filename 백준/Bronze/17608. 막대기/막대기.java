import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			stack.add(Integer.parseInt(br.readLine()));
		}
		
		int answer = 1;
	
		int first = stack.pop();
		while (!stack.isEmpty()) {
			int second = stack.pop();
			
			if (first < second) {
				answer++;
				first = second;
			} 
		}
		System.out.println(answer);
	}

}
