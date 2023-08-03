import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited_dfs;
    static boolean[] visited_bfs;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited_dfs = new boolean[N + 1];
        visited_bfs = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph[node1].add(node2);
            graph[node2].add(node1);

            Collections.sort(graph[node1]);
            Collections.sort(graph[node2]);
        }

        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    public static void dfs(int start) {
        if (visited_dfs[start]) return;

        sb.append(start).append(" ");

        visited_dfs[start] = true;
        for (int i: graph[start]) {
            if (visited_dfs[i]) continue;
            dfs(i);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited_bfs[start] = true;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            for (int i: graph[node]) {
                if (visited_bfs[i]) continue;
                visited_bfs[i] = true;
                queue.add(i);
            }
        }

    }
}
