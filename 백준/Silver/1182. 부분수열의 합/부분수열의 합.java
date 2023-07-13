import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static int cnt; // 개수
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        selected = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        dfs(0, 0);
        if (S == 0) {
            System.out.println(cnt - 1);
        } else {
            System.out.println(cnt);
        }
//        System.out.println(cnt - 1);
    }
    // K번째 원소를 포함시킬 지 정하는 함수
    public static void dfs(int depth, int sum) {
        // 순서X 중복X
        // 잘못 접근 -> 순서 O 중복 O
        if (depth == N) { // 부분 수열을 하나 완성 시킨 상태
            // sum이 S와 같은 지 확인하기
            if (sum == S) cnt++;
        } else {
            // depth반째 원소를 포함시킬 지 결정하고 재귀 호출해주기
            // 포함을 시키고 싶다면
            dfs(depth + 1, sum + arr[depth]);
            // 포함X
            dfs(depth + 1, sum);
        }

        // 만들 수 있는 모든 경우의 수 구하기
//            for (int i = 0; i < N; i++) {
//                if (visited[i]) continue;
//
//                selected[depth] = arr[i];
//                visited[i] = true;
//                dfs(depth + 1, sum + selected[depth]);
//                visited[i] = false;
//                selected[depth] = 0;
//
//            }
//        }
    }
}
