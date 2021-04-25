package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면,
 * 그 수를 한수라고 한다.
 * 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
 * N 이 주어졌을 때, 1보다 크거나 같고,
 * N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
 */
public class Boj_1065 {
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        if (x < 100) {
            System.out.println(x);
        } else {
            int result = 99;
            for (int i = 100; i <= x; i++) {
                if (isHansu(i)) {
                    result++;
                }
            }
            System.out.println(result);
        }

    }

    public static boolean isHansu(int x) {
        int i = 0;
        boolean flag = false;

        int[] arr = new int[String.valueOf(x).length()];
        while (x > 0) {
            arr[i] = x % 10;
            x /= 10;
            i++;
        }

        int[] compareArr = new int[arr.length -1];
        for (int j = 0; j < arr.length; j++) {
            if (j != arr.length -1) {
                compareArr[j] = arr[j] - arr[j + 1];
            }
        }

        for (int j = 0; j < compareArr.length; j++) {
            if (j != compareArr.length -1) {
               flag =  compareArr[j] == compareArr[j+1] ? true : false;
            }
        }

        return flag;
    }
}
