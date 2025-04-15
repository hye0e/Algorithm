import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num++;
                if ((num) % 10 == 0) num = 1;
                sb.append((num) % 10).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}