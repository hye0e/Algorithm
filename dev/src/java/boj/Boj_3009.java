package boj;

import java.util.Scanner;

public class Boj_3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] xArr = new int[3];
        int[] yArr = new int[3];
        for (int i = 0; i < 3; i++) {
            xArr[i] = sc.nextInt();
            yArr[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        if (xArr[0] == xArr[1]) {
            sb.append(xArr[2] + " ");
        } else {
            if (xArr[1] == xArr[2]) {
                sb.append(xArr[0] + " ");
            } else {
                sb.append(xArr[1] + " ");
            }
        }
        // 0  1  2  3
        // 10 10 30 30
        // 10 30 30 10
        // 10 30 10 30
        // 30 30 10 10
        if (yArr[0] == yArr[1]) {
            sb.append(yArr[2]);
        } else {
            if (yArr[1] == yArr[2]) {
                sb.append(yArr[0]);
            } else {
                sb.append(yArr[1]);
            }
        }
        System.out.println(sb);
    }
}
