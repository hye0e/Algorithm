import java.util.Scanner;

public class Boj_2869 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int v = sc.nextInt();

        int cnt = 0;
        int sum = 0;

        while (sum != v) {
            sum += a;
            if (sum != v) {
                sum -= b;
            }
            cnt++;
        }

        System.out.println(cnt);
    }
}
