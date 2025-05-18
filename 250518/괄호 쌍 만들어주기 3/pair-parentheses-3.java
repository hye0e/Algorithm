import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String temp = br.readLine();
        
        int cnt = 0;
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '(') {
                for (int j = i + 1; j < temp.length(); j++) {
                    if (temp.charAt(j) == ')') cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}