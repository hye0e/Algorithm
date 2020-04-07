import java.util.Scanner;

public class Boj_1978 {
    /**
     * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < testCase; i++) {
           int num = sc.nextInt();
           if (num % 2 == 1 && (num % 5)/2 != 0 ) {
               cnt++;
           }
        }
        System.out.println(cnt);
    }
}
