package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
 *
 * 둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고,
 * 이어서 N명의 점수가 주어진다. 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
 *
 */
public class Boj_4344 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCnt; i++) {
            String[] inputArr = br.readLine().split(" ");
            double sum = 0;
            int scoreCnt = Integer.parseInt(inputArr[0]);

            for (int j = 1; j <= scoreCnt; j++) {
                sum += Integer.parseInt(inputArr[j]);
            }
            double ang = sum / scoreCnt;

            int cntOverAng = 0;
            for (int j = 1; j <= scoreCnt; j++) {
                if (Integer.parseInt(inputArr[j]) > ang) {
                    cntOverAng++;
                }
            }
            sb.append(String.format("%.3f", 100.0 * cntOverAng / scoreCnt ));
            sb.append("%\n");
        }
        System.out.print(sb);
    }
}
