package programmers;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class Prgmers_0424 {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = new int[3];

        for(int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i%student1.length]) answer[0]++;
            if (answers[i] == student2[i%student2.length]) answer[1]++;
            if (answers[i] == student3[i%student3.length]) answer[2]++;
        }

        int max = Math.max(Math.max(answer[0], answer[1]), answer[2]);

        ArrayList<Integer> answerList = new ArrayList<>();
        if(answer[0] == max) answerList.add(1);
        if(answer[1] == max) answerList.add(2);
        if(answer[2] == max) answerList.add(3);

        return answerList.stream().mapToInt(i -> i.intValue()).toArray();
    }

    @Test
    public void 정답체크() {
//        Assert.assertEquals(new int[]{1}, solution(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(new int[]{1, 2, 3}, solution(new int[]{1, 3, 2, 4, 2}));
    }
}
