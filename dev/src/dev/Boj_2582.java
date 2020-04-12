package dev;

import java.util.ArrayList;
import java.util.Scanner;

public class Boj_2582 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int min = sc.nextInt();
//        int max = sc.nextInt();

        ArrayList<Integer> primeList = isPrimeList(1, 20);
        for (int prime : primeList) {
            System.out.println(prime);
        }
    }
    static ArrayList<Integer> isPrimeList (int min, int max) {
        ArrayList<Integer> primeList = new ArrayList<>();
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= max; i++) {
            if (!isPrime[i]) continue;
            else primeList.add(i);
            for (int j = i * 2; j <= max; j += i) {
                isPrime[j] = false;
            }
        }
        return primeList;
    }
}
