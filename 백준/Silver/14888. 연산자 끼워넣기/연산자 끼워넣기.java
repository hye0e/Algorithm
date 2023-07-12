import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, max, min;
    static int[] nums, operators, selected;
    /**
     * 문제 파악하기 - 정답의 최대치 int (-21억 ~ 21억) -> int 형 변수
     * N-1개의 카드 중복X + 순서있게
     */
    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        operators = new int[4];
        selected = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st2.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(0);
        System.out.println(max);
        System.out.println(min);
        // 연산 [N-1]
    }
    // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
    static int calculator() {
        int value = nums[0];
        for (int i = 1; i < N; i++) {
            // value, order[i], num[i+1]
            if (selected[i - 1] == 0) // +
                value = value + nums[i];
            if (selected[i - 1] == 1) // +
                value = value - nums[i];
            if (selected[i - 1] == 2) // +
                value = value * nums[i];
            if (selected[i - 1] == 3) // +
                value = value / nums[i];
        }
        return value;
    }
    // order[1..N-1] 에 연산자들이 순서대로 저장될 것
    public static void dfs(int depth) {
        if (depth == N - 1) { // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
            // 정한 연산자 순서대로 계산해서 정답을 갱신하기
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else { // depth 번째 연산자는 무엇을 선택할 것인가
            // 4가지의 연산자들 중에 무엇을 쓸 것인지 선택하고 재취호출하기
            for (int i = 0; i < 4; i++) {
                // 남아있는 연산의 개수가 있는지
                if (operators[i] >= 1) {
                    operators[i]--;
                    // 선택한 연산자
                    selected[depth] = i;
                    dfs(depth + 1);
                    // 취소
                    operators[i]++;
                    selected[depth] = 0;
                }
            }
        }
    }
}
