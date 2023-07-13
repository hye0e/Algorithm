import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static int[] selected;
    static boolean[] visited;
    static char[] password;
    static StringBuilder stringBuilder = new StringBuilder();

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        password = new char[C];
        selected = new int[L];
        visited = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            password[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(password);
    }

    public static void main(String[] args) throws IOException {
        input();
        dfs(0, 0);
        System.out.println(stringBuilder);
    }

    public static boolean valid() {
        int aeiou = 0;
        int elseCnt = 0;

        for (int i = 0; i < L; i++) {
            if (password[selected[i]] == 'a' || password[selected[i]] == 'e' || password[selected[i]] == 'i' || password[selected[i]] == 'o' || password[selected[i]] == 'u') {
                aeiou++;
            } else {
                elseCnt++;
            }
        }

        if (aeiou >= 1 && elseCnt >= 2) {
            return true;
        }
        return false;
    }
    public static void dfs(int start, int depth) {
        if (depth == L) {
            // a, e, i, o, u 체크
            if (valid()) {
                for (int i = 0; i < L; i++) stringBuilder.append(password[selected[i]]);
                stringBuilder.append("\n");
//                System.out.println(Arrays.toString(selected));
            }
        } else {
            // 순서O 중복X
            for (int i = start; i < C; i++) {
                selected[depth] = i;
                dfs(i + 1, depth + 1);
                selected[depth] = 0;
            }
        }
    }
}
