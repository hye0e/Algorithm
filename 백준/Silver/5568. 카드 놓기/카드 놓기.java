import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int n;
    static int k;
    static int[] number;
    static boolean[] visited;
    static int[] selected;
    static HashSet<String> answer = new HashSet<>();

    public static void dfs(int depth) {
        if (depth == k) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < k; i++) {
                sb.append(selected[i]);
            }
            answer.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            selected[depth] = number[i];
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
            selected[depth] = 0;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        number = new int[n];
        selected = new int[k];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);

        System.out.println(answer.size());
    }
}
