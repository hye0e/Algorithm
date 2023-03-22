import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Place {
    int x;
    int y;
    int dis;
    int drill;
    
	public Place(int x, int y, int dis, int drill) {
		super();
		this.x = x;
		this.y = y;
		this.dis = dis;
		this.drill = drill;
	}

	@Override
	public String toString() {
		return "Place [x=" + x + ", y=" + y + ", dis=" + dis + ", drill=" + drill + "]";
	}
}

public class Main {

	static int[][] graph;
    static int[][] memorization;
    static boolean[][] isVisited;
    static int N;
    static int M;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];
        memorization = new int[N][M];
        
        Queue<Place> wallQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = temp.charAt(j) - '0';
                memorization[i][j] = Integer.MAX_VALUE;
//                if (graph[i][j] == 1) {
                	
//                    wallQueue.offer(new Place(i, j));
//                }
            }
        }

        // queue에 경우의 벽을 다 넣기
//        Queue<Node> wallQueue = new LinkedList<>();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                if (graph[i][j] == 1) {
//                    wallQueue.offer(new Node(i, j));
//                }
//            }
//        }

        answer = Integer.MAX_VALUE;
        bfs();
//        while (!wallQueue.isEmpty()) {
//            Node wall = wallQueue.poll();
//            graph[wall.x][wall.y] = 0;
//            bfs();
//            if (memorization[N - 1][M - 1] != 0) {
//                answer = Math.min(answer, memorization[N - 1][M - 1]);
//            }
//
//            graph[wall.x][wall.y] = 1;
//        }

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    public static void bfs() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 초기화
        isVisited = new boolean[N][M];
        
        // 처음 칸 세서
        memorization[0][0] = 0;

        Queue<Place> queue = new LinkedList<>();
        queue.offer(new Place(0, 0, 1, 0)); 
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Place place = queue.poll();
            int x = place.x;
            int y = place.y;

            if (x == N - 1 && y == M - 1) {
            	answer = place.dis;
            	break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (memorization[nx][ny] <= place.drill) continue;

                    if (graph[nx][ny] == 0) {
                    	memorization[nx][ny] = place.drill;
                        queue.offer(new Place(nx, ny, place.dis + 1, place.drill));
                    } else {
                    	if (place.drill == 0) {
                    		memorization[nx][ny] = place.drill + 1;
                            queue.offer(new Place(nx, ny, place.dis + 1, place.drill + 1));
                    	}
                    }
                }
            }
        }
    }

}
