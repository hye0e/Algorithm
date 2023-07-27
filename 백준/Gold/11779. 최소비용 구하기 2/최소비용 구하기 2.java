import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int v;
        int cost;

        public Node (int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int N, M;
    static ArrayList<Node>[] graph;
    static int[] dist;
    static int[] preCity;
    static boolean[] visited;
    static int a, b;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        dist = new int[N + 1];
        visited = new boolean[N + 1];
        preCity = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        dist[start] = 0;
        queue.add(new Node(start, 0));
        List<Integer> cycle = new ArrayList<>();

        while(!queue.isEmpty()) {
            Node now = queue.poll();
            int cur = now.v;
            if (!visited[now.v]) visited[now.v] = true;
//            cycle.add(now.v);
            
            if (dist[now.v] < now.cost) continue;


            for (Node next: graph[now.v]) {
                if (!visited[next.v] && dist[next.v] > now.cost + next.cost) {
//                    cycle.add(next.v);
                    preCity[next.v] = cur; // 이전 마을 기록
                    dist[next.v] = now.cost + next.cost;
                    queue.add(new Node(next.v, dist[next.v]));
                }
            }
//            System.out.println(cycle);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        dijkstra(a);

        StringBuilder sb = new StringBuilder();
        // 최단거리
        sb.append(dist[b]).append("\n");
//        System.out.println(dist[b]);
        // 경로 역추적
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(b);
        while (preCity[b] != 0) {
            cnt++;
            stack.push(preCity[b]);
            b = preCity[b];
        }
        sb.append(cnt + 1).append("\n");

//        System.out.println(cnt + 1);

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
//            System.out.print(stack.pop() + " ");
        }
        System.out.println(sb);

    }
}
