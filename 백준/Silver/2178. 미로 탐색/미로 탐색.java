import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x, y;

	public Pair(int x, int y) {
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

	static StringTokenizer st;
	static int N, M;
	static int answer;
	static int[][] graph;
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
	
		graph = new int[N][M];
		isVisited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			String[] tempArr = temp.split("");
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(tempArr[j]);
			}
		}
		
		bfs();
		System.out.println(graph[N-1][M-1]);
	}

	public static void bfs() {
		answer = 0;
		Queue<Pair> queue = new LinkedList<>();
		queue.offer(new Pair(0, 0));
		isVisited[0][0] = true;
		
		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int x = p.x;
			int y = p.y;
			
			int[] dx = {-1, +1, 0, 0};
			int[] dy = {0, 0, -1, +1};
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (0 <= nx && nx < N && 0 <= ny && ny < M) {
					if (graph[nx][ny] == 1 && !isVisited[nx][ny]) {
						graph[nx][ny] = graph[x][y] + 1;
						isVisited[nx][ny] = true;
						queue.offer(new Pair(nx, ny));
					}
				}
			}
		}
	}
}
