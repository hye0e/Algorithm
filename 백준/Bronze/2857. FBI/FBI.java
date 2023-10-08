import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fbi = new String[5];
        for (int i = 0; i < 5; i++) {
            fbi[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        boolean find = false;
        for (int i = 0; i < 5; i++) {
            if (fbi[i].contains("FBI")) {
                find = true;
                sb.append(i + 1).append(" ");
            }
        }

        if (find) {
            System.out.println(sb);
        } else {
            System.out.println("HE GOT AWAY!");
        }
    }
}
