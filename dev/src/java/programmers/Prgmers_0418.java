package programmers;

import org.junit.Assert;
import org.junit.Test;

public class Prgmers_0418 {
    public String solution(String new_id) {
        String s = new KAKAOID(new_id)
            .replaceToLowerCase()
            .filter()
            .toSingleDot()
            .noStartEndDot()
            .noBlank()
            .noGreaterThan16()
            .noLessThan2()
            .getResult();


        return s;
    }

    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }

    @Test
    public void 정답() {
        Assert.assertEquals("bat.y.abcdefghi", solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
