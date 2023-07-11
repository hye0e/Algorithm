import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] card = new int[N];

        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] findNum = new int[M];
        for (int i = 0; i < M; i++) {
            findNum[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(card);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            sb.append(upperbound(card, findNum[i]) - lowerBound(card, findNum[i])).append(' ');
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key) {
        int min = 0;
        int max = arr.length;

        while (min < max) {
            int mid = (min + max) / 2;
            if (key <= arr[mid]) {
                max = mid; // 그 뒤는 볼 거 없음
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private static int upperbound(int[] arr, int key) {
        int min = 0;
        int max = arr.length;
        while (min < max) {
            int mid = (min + max) / 2;
            if (key < arr[mid]) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
