package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
 * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
 * aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
 *
 * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
 */
public class Boj_1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int cnt = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < cnt; i++) {
            String input = bufferedReader.readLine();
            if (checkGroup(input)) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean checkGroup(String input) {
        boolean[] checkArr = new boolean[26];
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char temp = input.charAt(i);
            if (checkArr[temp - 'a']) {
                return false;
            } else {
                // i < length-1
                if(temp != input.charAt(i+1)) {
                    checkArr[temp-'a'] = true;
                }
            }
        }

        return true;
    }
}
