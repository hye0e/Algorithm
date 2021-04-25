package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj_2582 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int min = sc.nextInt();
        int max = sc.nextInt();

        ArrayList<Integer> primeList = isPrimeList(1, max);
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int prime : primeList) {
            if (prime >= min && prime <= max ) {
                sum += prime;
                result.add(prime);
            }
        }

        if (!result.isEmpty()) {
            Collections.sort(result);
            sb.append(sum + "\n");
            sb.append(result.get(0));
        } else {
            sb.append("-1");
        }

        System.out.println(sb);
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
