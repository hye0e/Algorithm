package dev;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Boj_7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int[] xArr = new int[testCase];
        int[] yArr = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            xArr[i] = sc.nextInt();
            yArr[i] = sc.nextInt();
        }

        int[] xSortArr = new int[testCase];
        int[] ySortArr = new int[testCase];
        for (int i = 0; i < testCase; i++) {
            for (int j = i + 1; j < testCase; j++) {
                if (xArr[i] < xArr[j]) {
                    xSortArr[i] = xArr[i];
                }
            }
        }
    }
}
