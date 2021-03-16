package programmers;

import java.util.Arrays;

public class prgmers_0316 {
    public static void main(String[] args) {
        String answer = "";
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                answer = participant[i];
            }
        }

        System.out.println(answer);
    }
}
