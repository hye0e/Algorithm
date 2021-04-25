package boj;

import java.util.Scanner;

public class Boj_2440 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int star = sc.nextInt();
        for (int i = star; i > 0; i--) {
            System.out.print("*");
            for (int j = i - 1; j > 0; j-- ) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
