import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int answer = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int i = 0;
        int j = num.length - 1;

        int num1 = 0;
        int num2 = 0;

        int temp = Integer.MAX_VALUE;
        while (i < j) {
            int mixed = Math.abs(num[i] + num[j]);

            if (mixed < temp) {
                temp = mixed;
                num1 = num[i];
                num2 = num[j];
            }
            if (num[i] + num[j] < 0) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println(num1 + " " + num2);
    }
}
