import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Integer>> graph = new ArrayList<>();
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		isVisited = new boolean[N + 1];
		
		for(int i = 0; i < N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int edge = Integer.parseInt(st.nextToken());

			graph.get(node).add(edge);
			graph.get(edge).add(node);
		}
		
		int answer = 0;
		for (int i = 1; i < graph.size(); i++) {
			if (!isVisited[i]) {
				answer++;
				dfs(i);
			}
		}
		
		System.out.println(answer);
	}
	
	public static void dfs(int x) {
		if (isVisited[x]) return;
		
		isVisited[x] = true;
		
		for (int i = 0; i < graph.get(x).size(); i++) {
			if (!isVisited[graph.get(x).get(i)]) {
				dfs(graph.get(x).get(i));
			}
		}
	}

}
