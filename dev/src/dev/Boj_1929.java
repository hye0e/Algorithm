package dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj_1929 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<Integer> primeList = primeList(n);
        for (int prime : primeList) {
            if (prime >= m && prime <= n) {
                System.out.println(prime);
            }
        }
    }

    public static List<Integer> primeList(int max) {
        List<Integer> primeList = new ArrayList<>();
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) primeList.add(i);
            else continue;
            for (int j = i * 2; j <= max; j += i) {
                isPrime[j] = false;
            }
        }
        return primeList;
    }
}
