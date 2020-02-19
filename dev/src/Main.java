import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String input = br.readLine();
        st = new StringTokenizer(input, " ");

        int size = Integer.parseInt(st.nextToken());
        int min = Integer.parseInt(st.nextToken());

        List<Integer> numList = new ArrayList<>();

        String arr = br.readLine();
        st = new StringTokenizer(arr," ");

        for (int i = 0; i < size; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }

        for (int num : numList) {
            if (num < min) {
                sb.append(num + " ");
            }
        }

        System.out.println(sb);
        System.out.println(sb);
    }
}
