import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int internalSum = 0;

        int[] arr = new int[N];
        int[] prefixSum = new int[N];

        int answer = Integer.MAX_VALUE;
        String[] temp = br.readLine().split(" ");
        for (int i = 0; i < temp.length; i++) {
            arr[i] = Integer.parseInt(temp[i]);
            if (i == 0) {
                prefixSum[i] = arr[i];
            } else {
                prefixSum[i] = prefixSum[i - 1] + arr[i];
            }
        }

        int end = 0;
        for (int start = 0; start < N; start++) {
            while (internalSum < S && end < N) {
                internalSum += arr[end];
                end++;
            }
            if (internalSum >= S) {
                answer = Math.min(answer, end  - start);
            }
            internalSum -= arr[start];
        }
        
        if (answer == Integer.MAX_VALUE) answer = 0;

        System.out.println(answer);
    }
}
