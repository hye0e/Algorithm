import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // 노드 개수
    static int person1, person2;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean nothing = true;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        person1 = Integer.parseInt(st.nextToken());
        person2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        dfs(person1, 0);

        if (nothing) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static void dfs(int start, int depth) {
        if (visited[start]) {
            return;
        }

        if (start == person2) {
            nothing = false;
            ans = depth;
            return;
        }

        visited[start] = true;

        for (int i: graph[start]) {
            if (visited[i]) continue;
            dfs(i, depth + 1);
            visited[i] = true;
        }
    }
}
