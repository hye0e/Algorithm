import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] graph;
    
    static int N;
    static int findNum;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        findNum = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        int x = 0;
        int y = 0;
        int dir = 0;
        int num = N * N;
        for (int i = 0; i < N * N; i++) {
            graph[x][y] = num--;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || graph[nx][ny] != 0) {
                dir = (dir + 1) % 4;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }
            
            x = nx;
            y = ny;
        }
        
        StringBuilder sb = new StringBuilder();
        int findX = 0;
        int findY = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == findNum) {
                    findX = i;
                    findY = j;
                }
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append((findX+1) + " " + (findY+1));
        System.out.println(sb);
    }
}