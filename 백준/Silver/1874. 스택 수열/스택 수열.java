import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
//		List<Integer> numList = new ArrayList<>();
//		for (int i = 0; i < N; i++) {
//			numList.add(Integer.parseInt(br.readLine()));
//		}

		int num = 1;
		boolean possible = true;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			int check = Integer.parseInt(br.readLine());
			
			if (check < num && check != stack.peek()) {
				possible = false;
				break;
			}
			while (num <= check) {
				stack.add(num++);
				sb.append("+\n");
			}
			stack.pop();
			sb.append("-\n");
		}
		
		if (possible) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}

}
