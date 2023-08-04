import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);

            Collections.sort(graph[node1]);
            Collections.sort(graph[node2]);
        }

        dfs(1);
        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int start) {
        if (visited[start]) return;

        visited[start] = true;

        for (int i: graph[start]) {
            if (visited[i]) continue;
            parent[i] = start;
            dfs(i);
        }
    }
}
