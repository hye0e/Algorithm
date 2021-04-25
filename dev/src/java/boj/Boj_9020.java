package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int testCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCnt; i++) {
            int min = 1000;
            int input = Integer.parseInt(br.readLine());
            List<Integer> primeList = getPrimeList(input);
            List<Integer> minList = new ArrayList<>();
            int temp = input;
            for (int j = primeList.size() - 1; j >= 0; j--) {
                temp -= primeList.get(j);
                if (primeList.contains(temp) && !result.contains(temp)) {
                    result.add(temp);
                    result.add(primeList.get(j));
                }
                min = min < Math.abs(temp - primeList.get(j)) ? min : Math.abs(temp - primeList.get(j));
                if (min ==  Math.abs(temp - primeList.get(j))) {
                    result.clear();
                    result.add(temp);
                    result.add(primeList.get(j));
                }
                temp = input;
            }
        }
        for (int num : result) {
            System.out.println(num);

        }
    }
    public static List<Integer> getPrimeList(int max) {
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
