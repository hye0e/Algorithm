import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class ClassGrade implements Comparable<ClassGrade> {
        String name;
        int kor;
        int eng;
        int math;

        public int getKor() {
            return kor;
        }

        public int getEng() {
            return eng;
        }

        public int getMath() {
            return math;
        }

        public String getName() {
            return name;
        }

        public ClassGrade(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(ClassGrade o) {
            if (this.kor == o.getKor()) {
                if (this.eng == o.getEng()) {
                    if (this.math == o.getMath()) {
                        return this.getName().compareTo(o.getName());
                    }
                    return o.math - this.math;
                }

                return this.eng - o.eng;
            }
            return o.kor - this.kor;
        }
    }
    static int N;
    static boolean allSame;

    public static void input() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ClassGrade[] gradeList = new ClassGrade[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gradeList[i] = new ClassGrade(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//            gradeList.add(new ClassGrade(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

//        Collections.sort(gradeList);
        Arrays.sort(gradeList);
        for (ClassGrade cg : gradeList) {
            System.out.println(cg.getName());
        }
    }
    public static void main(String[] args) throws IOException {
        input();
    }
}
