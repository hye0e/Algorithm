import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1]; // 0번 노드부터 시작
		visited = new boolean[N+1];
		
		for (int i = 0; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			graph[from].add(to);
			graph[to].add(from);
		}
		
		int answer = 0;
		for (int i = 1; i < N+1; i++) {
			if (!visited[i]) {
				answer++;
				DFS(i);
			}
		}
		
		System.out.println(answer);
	}
	
	public static void DFS(int currNode) {
		if (visited[currNode]) return;
		visited[currNode] = true;
		for (int node: graph[currNode]) {
			if (!visited[node]) {
				DFS(node);
			}
		}		
	}

}
