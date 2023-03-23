import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int answer;
    static Integer[] coin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new Integer[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coin, Collections.reverseOrder());

        int total = K;
        for (int i = 0; i < N; i++) {
            if (total < coin[i]) continue;
            if (total == 0) continue;
            int cnt = total / coin[i];
            total -= cnt * coin[i];
            answer += cnt;
        }
        System.out.println(answer);
    }
}
