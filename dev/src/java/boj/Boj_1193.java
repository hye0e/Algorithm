package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int line = 0;
        int cnt = 0;
        while(cnt < n) {
            line++;
            cnt = line * (line+1) / 2;
        }
        if( line % 2 != 0) {
            int top = 1+(cnt-n);
            int bottom = line - (cnt-n);
            System.out.println(top+"/"+bottom);
        }else {
            int top = line - (cnt - n);
            int bottom = 1 + (cnt - n);
            System.out.println(top+"/"+bottom);
        }// end if
    }
}
