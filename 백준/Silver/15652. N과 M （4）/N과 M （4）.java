import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 1, 2, 3, 4
        M = Integer.parseInt(st.nextToken()); // 2

        selected = new int[M + 1];
        dfs(1);
        System.out.println(sb);
    }

    public static void dfs(int depth) {
        if (depth == M + 1) {
            for (int i = 1; i <= M; i++) { // 0, 1, 2
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 1; i <= N; i++) {
                selected[depth] = i;
                if (selected[depth - 1] <= selected[depth]) {
                    dfs(depth + 1);
                    selected[depth] = 0;
                }
            }
        }
    }
}
