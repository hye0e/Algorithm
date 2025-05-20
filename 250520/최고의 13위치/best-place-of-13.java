import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] nRows = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nRows[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 2; j++) {
                int temp = nRows[i][j] + nRows[i][j + 1] + nRows[i][j + 2];
                cnt = Math.max(cnt, temp); 
            }
            
        }
        System.out.println(cnt);
    }
}