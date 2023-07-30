import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static int answer = 0;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void twoPointer() {
        int internalSum = 0;
        int end = 0;
        for (int start = 0; start < N; start++) {
            while (internalSum < M && end < N) {
                internalSum += arr[end];
                end++;
            }

            if (internalSum == M) {
                answer++;
            }

            internalSum -= arr[start];
        }
        System.out.println(answer);
    }
    
    public static void main(String[] args) throws IOException {
        input();
        twoPointer();
    }
}
