import java.util.Scanner;

public class Boj_10250 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testCnt = sc.nextInt();
        for (int i = 0; i < testCnt; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            int num;
            int floor = (N % H);
            if (floor == 0) {
                floor = H;
                num = (N / H);
            } else {
                num = (N / H) + 1;
            }
            sb.append(floor * 100 + num + "\n");

        }
        System.out.println(sb);
    }
}
