package programmers.level_1;

import java.time.LocalDate;

class S_PG_2016 {
    public String solution(int a, int b) {
        String answer = ""; // 2016년 a월 b일의 요일

        LocalDate date = LocalDate.of(2016, a, b);
        answer = date.getDayOfWeek().toString().substring(0, 3);

        return answer;
    }
}

public class PG_2016 {
    public static void main(String[] args) {
        S_PG_2016 s = new S_PG_2016();
        System.out.println(s.solution(5, 24));
    }
}
