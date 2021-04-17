package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_4948 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int num = Integer.parseInt(br.readLine());
            List<Integer> result = new ArrayList<>();
            if (num != 0) {
                List<Integer> primeList = getPrimeList(2 * num);
                for (int prime : primeList) {
                    if (num < prime) {
                        result.add(prime);
                    }
                }
                sb.append(result.size() + "\n");
            } else {
                break;
            }

        }
        System.out.println(sb);
    }

    public static List<Integer> getPrimeList (int MAX) {
        List<Integer> primeList = new ArrayList<>();
        boolean[] isPrime = new boolean[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) primeList.add(i);
            else continue;
            for (int j = i * 2; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
        return primeList;
    }
}
