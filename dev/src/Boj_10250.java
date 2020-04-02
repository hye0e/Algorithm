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
            int floor = (N % H) * 100;
            if (floor == 0) {
                sb.append(H * 100 + N +  "\n");
            } else {
                int num = (N / H) + 1;
                int roomNum = floor + num;

                sb.append(roomNum + "\n");
            }
        }

        System.out.println(sb);
    }
}
