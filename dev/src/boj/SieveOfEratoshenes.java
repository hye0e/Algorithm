package boj;

import java.util.ArrayList;

public class SieveOfEratoshenes {

    public static final int MAX = 25;

    public static void main(String[] args) {
        ArrayList<Integer> primeList = new ArrayList<>();
        boolean isPrime[] = new boolean[MAX + 1];
        for(int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }
        for(int i = 2; i <= MAX; i++) {
            if(!isPrime[i]) continue;
            else primeList.add(i);
            for(int j = i*2; j <= MAX; j += i) {
                isPrime[j] = false;
            }
        }
        for(int i = 0; i < primeList.size(); i++) {
            System.out.println(primeList.get(i));
        }
    }
}
