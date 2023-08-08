import java.util.*;

class Solution {
    int[][] graph;
    int N, M; // 가로, 세로
    boolean[][] visited;
    
    class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        
        graph = new int[N][M];
        visited = new boolean[N][M];
        
        for (int i = 0; i < N; i++) {
            char[] temp = maps[i].toCharArray();
            System.out.println(Arrays.toString(temp));
            for (int j = 0; j < M; j++) {
                if (temp[j] == 'X') {
                    graph[i][j] = -1;
                } else {
                    graph[i][j] = temp[j] - '0';
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] != -1 && !visited[i][j]) {
                    int temp = bfs(i, j);
                    System.out.println(temp);
                    if (temp != 0) answer.add(temp);
                }
            }
        }
        if (answer.size() == 0) answer.add(-1);        
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int bfs(int x, int y) {
        int sum = graph[x][y];
        visited[x][y] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
                
        while (!queue.isEmpty()) {
            Node newNode = queue.poll();
            
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            
            for (int i = 0; i < 4; i++) {
                int nx = newNode.x + dx[i];
                int ny = newNode.y + dy[i];
                
                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (!visited[nx][ny] && graph[nx][ny] != -1) {
                        visited[nx][ny] = true;
                        queue.add(new Node(nx, ny));
                        sum += graph[nx][ny];
                    } 
                }
            }
        }
        
        return sum;
    }
}