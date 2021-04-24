package programmers;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

public class Prgmers_0424 {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        student1 = formatAnswer(answers.length, student1);
        student2 = formatAnswer(answers.length, student2);
        student3 = formatAnswer(answers.length, student3);

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(answerCheck(student1, answers));
        arr.add(answerCheck(student2, answers));
        arr.add(answerCheck(student3, answers));
            // 1번 비교 == 2번 비교 -> answer[0] = 1, 2
            // 2번 비교 == 3번 비 -> answer[0] = 1, 2, 3
            return new int[]{1, 2,3};
    }
    private static int answerCheck(int[] studentArr, int[] answer) {
        int correctCnt = 0;
        for(int i = 0; i < studentArr.length; i++) {
            if(studentArr[i] == answer[i]) {
                correctCnt++;
            }
        }
        return correctCnt;
    }
    private static int[] formatAnswer(int answerCnt, int[] studentAnswer) {
        int[] formatArr = new int[answerCnt];

        for(int j = 0; j < studentAnswer.length; j++) {
            if (j < answerCnt) {
                formatArr[j] = studentAnswer[j];
            }
        }

        for(int i = studentAnswer.length; i < answerCnt; i++) {
            formatArr[i] = studentAnswer[i%studentAnswer.length];
        }
        return formatArr;
    }

    @Test
    public void 정답체크() {
        Assert.assertEquals(new int[]{1, 2, 3, 4, 5}, solution(new int[]{1,2,3,4,5}));
    }
}
