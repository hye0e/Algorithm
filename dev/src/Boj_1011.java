import java.util.Scanner;

public class Boj_1011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long testCase = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (long i =  0; i < testCase; i++) {
            long x = sc.nextLong();
            long y = sc.nextLong();

            long[] arr = distanceCal(x);
            long cnt = x == 0 ? 1 : 0;

            while (arr[2] != y) {
                arr = distanceCal(arr[2]);
                cnt++;
            }

            sb.append(cnt + "\n");
        }
        System.out.println(sb);
    }

    public static long[] distanceCal (long input) {
        long[] result = new long[3];
        result[0] = input - 1;
        result[1] = input;
        result[2] = input + 1;

        return result;
    }
}
