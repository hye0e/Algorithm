import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int diff = Integer.MAX_VALUE;
    static int answer1, answer2;
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
    }

    public static void solve() {
        int start = 0;
        int end = arr.length - 1;

        int internalSum;
        while (start < end) {
            internalSum = Math.abs(arr[start] + arr[end]);
            if (internalSum < diff) {
                diff = internalSum;
                answer1 = arr[start];
                answer2 = arr[end];
            }

            // 양수면 오른쪽 방향을 좀 더 음수쪽으로
            if (arr[start] + arr[end] > 0) end--;
            // 음수면 왼쪽 방향을 좀 더 양수족으로
            else start++;
        }
        System.out.println(answer1 + " " + answer2);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
