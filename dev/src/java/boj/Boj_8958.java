package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
 *  문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
 *
 * "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.
 *
 * OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
 *
 *
 */
public class Boj_8958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        String[] inputArr = new String[cnt];

        for (int i = 0; i < cnt; i++) {
            inputArr[i] = br.readLine();
        }

        for (int i = 0; i < cnt; i++) {
            int sum = 0;
            int score = 0;
            String[] answer = inputArr[i].split("");
            for (int j = 0; j < answer.length; j++) {
                if (answer[j].equals("O")) {
                    score++;
                    sum += score;
                } else if (answer[j].equals("X")){
                    score = 0;
                }

            }
                sb.append(sum + "\n");
        }

        System.out.println(sb);
    }
}
