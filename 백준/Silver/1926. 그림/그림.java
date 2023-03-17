import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1
 */
class Node {
	int x, y;
	
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Node [x=" + x + ", y=" + y + "]";
	}
}
public class Main {
	static int[][] graph;
	static int N; // 세로
	static int M; // 가로
	static boolean[][] isVisited;
	
	static int cnt;
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[N][M]; 
		isVisited = new boolean[N][M]; 
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {				
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		List<Integer> cntList = new ArrayList<>();
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {	
				if (graph[i][j] == 1 && !isVisited[i][j]) {
					bfs(i, j);
					answer = Math.max(answer, cnt);
					cntList.add(cnt);
//					System.out.println(cnt);
				}
			}
		} 
		sb.append(cntList.size()).append("\n");
		sb.append(answer);
		System.out.println(sb);
	} 
	
	public static void bfs(int x, int y) {
		cnt = 1;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		
		isVisited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();

			x = node.x;
			y = node.y;
			
			int[] dx = {-1, +1, 0, 0};
			int[] dy = {0, 0, -1, +1};
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (!isVisited[nx][ny] && graph[nx][ny] == 1) {
						cnt++;
						isVisited[nx][ny] = true;
						
						queue.offer(new Node(nx, ny));
						
					}
				}
			}
		}
	}

}

