import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    static class Word implements Comparable<Word> {
        String word;
        int length;

        public Word(String word, int length) {
            this.word = word;
            this.length = length;
        }

        @Override
        public int compareTo(Word o) {
            if (this.length == o.length) return word.compareTo(o.word);
            return this.length - o.length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Word> word = new ArrayList<>();
        HashMap<String, Integer> words = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            words.put(input, input.length());
        }

        for (String key: words.keySet()) {
            word.add(new Word(key, key.length()));
        }

        Collections.sort(word);
        for (Word w: word) {
            System.out.println(w.word);
        }
    }
}
