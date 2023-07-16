import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        input();
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> card = new HashMap<>();

        int max = 0;
        long num = (long) 0;
        for (int i = 0; i < N; i++) {
            Long input = Long.valueOf(br.readLine());
            int cnt = card.getOrDefault(input, 0);
            card.put(input, cnt + 1);

            // 가장 많이 가지고 있는 정수
            if (card.get(input) > max) {
                max = card.get(input);
                num = input;
            } else if (card.get(input) == max) {
                num = Math.min(input, num);
            }
        }
        System.out.println(num);
    }
}

