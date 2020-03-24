import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 경
 * č	c=
 * ć	c-
 * dž	dz=
 * đ	d-
 * lj	lj
 * nj	nj
 * š	s=
 * ž	z=
 */
public class Boj_2941 {
    public static void main(String[] args) throws IOException {
        String[] alpArr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");

        int cnt = 0;
        int charNum = 0;
        // 위 목록에 없는 알파벳은 한 글자씩 센다. // lj e s= nj a k
        for (int i = 0; i < input.length; i++) {
           charNum += input[i].charAt(0);

        }

    }
}
