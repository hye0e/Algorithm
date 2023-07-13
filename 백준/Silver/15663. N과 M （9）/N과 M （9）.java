import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
//    static Queue<String> answer = new LinkedList<>();

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        visited = new boolean[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        System.out.println(sb);
//        printAns();
    }

//    private static void printAns() {
//
//        while (!answer.isEmpty()) {
//            String[] temp = answer.poll().split("/");
//            for (String t : temp) {
//                sb.append(t).append(" ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }

    public static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
//            String temp = "";
//            for (int i = 0; i < M; i++) {
//                if (i == M - 1) {
//                    temp += selected[i];
//                } else {
//                    temp += selected[i] + "/";
//                }
//            }
//            if (!answer.contains(temp)) answer.add(temp);
        } else {
            int last = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                if (last == nums[i]) continue;
                // 추가
                last = nums[i];
                selected[depth] = nums[i];
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
                selected[depth] = 0;
            }
        }
    }
}
