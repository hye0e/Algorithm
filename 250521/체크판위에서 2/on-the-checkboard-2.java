import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    static int R;
    static int C;
    static char[][] grid;
    
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        grid = new char[R][C];

        for(int i = 0; i < R; i++) {
            String temp = br.readLine();
            for(int j = 0; j < C; j++) {
                grid[i][j] = temp.charAt(j);
            }
        }
            
        int cnt = 0;
        for(int i = 1; i < R; i++)
            for(int j = 1; j < C; j++)
                for(int k = i + 1; k < R - 1; k++)
                    for(int l = j + 1; l < C - 1; l++)
                        // 그 중 색깔이 전부 달라지는 경우에만 개수를 세줍니다.
                        if(grid[0][0] != grid[i][j] && 
                           grid[i][j] != grid[k][l] &&
                           grid[k][l] != grid[R - 1][C - 1])
                            cnt++;
        
        System.out.println(cnt);



    }
}