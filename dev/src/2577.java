import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 세 개의 자연수 A, B, C가 주어질 때 A×B×C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.

 예를 들어 A = 150, B = 266, C = 427 이라면

 A × B × C = 150 × 266 × 427 = 17037300 이 되고,

 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다.
 */
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int num1 = Integer.parseInt(br.readLine());
//        int num2 = Integer.parseInt(br.readLine());
//        int num3 = Integer.parseInt(br.readLine());
//
//        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//
//        int result = num1 * num2 * num3;
//        for (int i = 0; i < arr.length; i++) {
//            int cnt = 0;
//            int temp = result;
//
//            while (temp != 0) {
//                if (temp % 10 == arr[i]) {
//                    cnt++;
//                }
//                temp /= 10;
//            }
//            System.out.println(cnt);
//        }
//    }
//}
