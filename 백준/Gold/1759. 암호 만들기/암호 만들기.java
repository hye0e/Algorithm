import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int L, C;

	static char[] arr;
	static char[] password;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(arr);
		password = new char[L];
		
		dfs(0, 0);
		System.out.println(sb);
	}
	
	private static boolean check() {
		int aeiouCnt = 0;
		int restCnt = 0;
		for (int i = 0; i < password.length; i++) {
			if (password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || 
					password[i] == 'o' || password[i] == 'u' ) {
				aeiouCnt += 1;
			} else {
				restCnt += 1;
			}
		}
		
		if (aeiouCnt >= 1 && restCnt >= 2) {
			return true;
		}
		return false;
	}
	
	private static void dfs(int cnt, int startIndex) {
		if (cnt == L) {
			if (check()) {
				for (char c: password) {
					sb.append(c);
				}
				sb.append("\n");
			}

			return;
		}
		
		for (int i = startIndex; i < C; i++) {
			password[cnt] = arr[i];
			dfs(cnt + 1, i + 1);
		}
	}
}
