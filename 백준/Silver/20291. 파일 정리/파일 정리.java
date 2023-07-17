import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> fileMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            String[] file = input.split("[.]");
            int cnt = fileMap.getOrDefault(file[1], 0);
            fileMap.put(file[1], cnt+ 1);
        }

        List<String> list = new ArrayList<>(fileMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            System.out.println(key + " " + fileMap.get(key));
        }

    }
}
