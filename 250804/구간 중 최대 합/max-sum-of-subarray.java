import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] num = new int[K]; 
        for (int i = 0; i < K; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(Arrays.toString(num));

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i <= K- N; i++) {
            int temp = 0;
            for (int j = i; j < i + N; j++) {
                temp += num[j];
            }
           
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);

    }
}