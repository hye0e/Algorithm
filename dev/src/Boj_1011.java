import java.util.Scanner;

public class Boj_1011 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long case_count = in.nextInt();
        for (long i = 0; i < case_count; i++) {
            long x_pos = in.nextInt();
            long y_pos = in.nextInt();
            long length = y_pos - x_pos;
            long answer = 1;
            long dis = 0;

            while (length > dis) {
                answer++;
                dis += answer / 2;
            }
            System.out.println(answer - 1);
        }
    }
}
