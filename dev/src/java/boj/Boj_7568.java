package boj;

import java.util.Scanner;

public class Boj_7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCnt = sc.nextInt();
        int[] xArr = new int[testCnt];
        int[] yArr = new int[testCnt];
        int[] ans = new int[testCnt];
        for (int i = 0; i < testCnt; i++) {
            xArr[i] = sc.nextInt();
            yArr[i] = sc.nextInt();
        }

        for (int i = 0; i < testCnt; i++) {
            for (int j = 0; j < testCnt; j++) {
                if (i == j) continue;
                if (xArr[i] < xArr[j] && yArr[i] < yArr[j]) ans[i]++;
            }
        }

        for (int rank : ans) {
            System.out.print((rank+1) + " ");
        }
    }
}
