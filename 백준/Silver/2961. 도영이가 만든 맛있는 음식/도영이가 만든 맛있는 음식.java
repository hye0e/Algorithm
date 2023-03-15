import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, totalCnt;

	static int[] sArr;
	static int[] bArr;

	static boolean[] isSelected; // sArr
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		sArr = new int[N];
		bArr = new int[N];

		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sArr[i] = Integer.parseInt(st.nextToken());
			bArr[i] = Integer.parseInt(st.nextToken());
		}

		answer = Integer.MAX_VALUE;

		subset(0);
		System.out.println(answer);
	}

	private static void subset(int cnt) {
		if (cnt == N) {
			boolean flag = false;
			int sTemp = 1;
			int bTemp = 0;
			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					flag = true;
					sTemp *= sArr[i];
					bTemp += bArr[i];
				}
			}
			if (flag)
				answer = Math.min(answer, Math.abs(sTemp - bTemp));

			return;
		}

		// cnt번째 값을 뽑는 경우
		isSelected[cnt] = true;
		subset(cnt + 1);

		// cnt번째 값을 안뽑는 경우
		isSelected[cnt] = false;
		subset(cnt + 1);
	}

}
