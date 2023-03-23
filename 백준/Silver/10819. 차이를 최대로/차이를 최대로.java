import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] num;
    static int[] selecetedNum;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = new int[N];
        selecetedNum = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int cnt) {
        if (cnt == N) {
            answer = Math.max(sum(), answer);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            selecetedNum[cnt] = num[i];
            dfs(cnt + 1);
            visited[i] = false;
        }
    }

    public static int sum() {
        int sum=0;
        for(int i=0; i< N-1; i++){
            sum += Math.abs(selecetedNum[i]-selecetedNum[i+1]);
        }
        return sum;
    }
}
