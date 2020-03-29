import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2292 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            System.out.print(solution(n));
        }

        private static int solution(int input) {
            if (input == 1) return 1;

            int range = 1;
            int i = 2;

            while (i <= input) {
                i += 6 * range++;
            }

            return range;
        }
    }
