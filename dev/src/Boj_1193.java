import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1193 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int sum = 0;
        int temp = 0;
        for (int i = 1; i <= input; i++) {
            sum += i;
            if (sum >= input) {
                temp = i;
                break;
            } else {
                continue;
            }
        }

        int minus  = sum - input;
        StringBuilder sb = new StringBuilder();
        // 짝수일 때
        if (temp % 2 != 0) {
            sb.append((1 + minus) + "/" + (temp - minus));
        } else {
            sb.append((temp - minus) + "/" + (1 + minus));
        }

        System.out.println(sb);
    }
}
