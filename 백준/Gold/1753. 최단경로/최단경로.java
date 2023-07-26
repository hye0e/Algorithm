import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int vertex;
        int cost;

        public Node (int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
    static int V, E, K;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static boolean[] visited;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        dijkstra(K);
        print();
    }

    public static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) sb.append("INF").append("\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>(((o1, o2) -> o1.cost - o2.cost));
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (!visited[now.vertex]) visited[now.vertex] = true;

            for (Node next: graph[now.vertex]) {
                if (!visited[next.vertex] && dist[next.vertex] > now.cost + next.cost) {
                    dist[next.vertex] = now.cost + next.cost;
                    queue.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }
    }
}
