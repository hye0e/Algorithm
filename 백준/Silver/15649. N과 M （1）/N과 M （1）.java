import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1, 2, 3, 4
        M = Integer.parseInt(st.nextToken()); // 2

        selected = new int[M];
        visited = new boolean[N + 1];
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                if (visited[i]) continue;
                selected[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
                selected[depth] = 0;
            }
        }

    }
}
