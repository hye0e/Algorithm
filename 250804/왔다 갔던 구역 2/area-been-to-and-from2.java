import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        int[] count = new int[200];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int now = 100;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int go = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
        
            if (direction.equals("R")) {
                for (int j = now; j < now + go; j++) {
                    // System.out.println("R -> " + j);
                    count[j]++;
                    // now++;
                }
                now += go;
            } else {
                for (int j = now; j > now - go; j--) {
                    // System.out.println("L -> " + j);
                    count[j]++;
                    // last = j;
                }
                now -= go;

                // System.out.println("현재) " + now);
            }
        }
        int answer = 0;
        for (int i = 0; i < 200; i++) {
            if (count[i] >= 2) answer++;
        }
        System.out.println(answer);
    }
}