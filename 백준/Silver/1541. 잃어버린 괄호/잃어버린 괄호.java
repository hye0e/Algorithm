import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> num;
    static List<String> sign;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split("");
        // 숫자만
        num = new ArrayList<>();
        // 부호만
        sign = new ArrayList<>();

        format(temp);

        int answer = num.get(0);

        for (int i = 1; i < sign.size(); i++) {
            if (sign.get(i - 1).equals("-")) {
                sign.set(i, "-");
            }
        }

        for (int i = 0; i < sign.size(); i++) {
            if (sign.get(i).equals("-")) answer += num.get(i + 1) * (-1);
            else answer += num.get(i + 1);
        }

        System.out.println(answer);
    }

    public static void format(String[] temp) {
        int index = 0;
        while (true) {
            if (index > temp.length - 1) break;
            String tempStr = "";
            for (int i = index; i < temp.length; i++) {
                index = i + 1;
                if (temp[i].equals("-") || temp[i].equals("+")) {
                    sign.add(temp[i]);
                    break;
                }
                tempStr += temp[i];
            }
            num.add(Integer.valueOf(tempStr));
        }
    }
}
