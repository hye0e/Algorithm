import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static boolean[] visited;
    static int answer = 0;

    public static void dfs(int[] num, int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                answer++;
            }
            
            return;
        }

        dfs(num, depth + 1, sum + num[depth]);
        dfs(num, depth + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        dfs(num, 0, 0);
        if (S == 0) answer--;
        System.out.println(answer);
    }
}
