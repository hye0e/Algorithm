import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();

        // 알파벳
        int[] alpha = new int[26];
        for (int i = 0; i < name.length(); i++) {
            int index = name.charAt(i) - 'A';
            alpha[index]++;
        }

        // 홀수개의 갯수
        int oddCnt = 0;
        int mid = 0;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                mid = i;
                oddCnt++;
            }
        }

        StringBuilder front = new StringBuilder();
        // 홀수개가 1개가 아니면 펠린드롬을 만들 수 없음
        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    front.append((char) (i + 'A'));
                }
            }
            StringBuilder end = new StringBuilder(front).reverse();
            if (oddCnt == 1) {
                front.append((char) (mid + 'A'));
            }
            System.out.println(front.toString() + end.toString());
        }
    }
}
