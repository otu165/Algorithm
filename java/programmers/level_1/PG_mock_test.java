package programmers.level_1;

import java.util.ArrayList;
import java.util.List;

class S_PG_mock_test {
    public int[] solution(int[] answers) {
        int[] result;

        int[] array_1 = {1, 2, 3, 4, 5};
        int[] array_2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] array_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int score_1 = 0, score_2 = 0, score_3 = 0;


        for (int i = 0; i < answers.length; i++) {
            // 1번 수포자 정답 수 카운트
            if(array_1[i % 5] == answers[i])
                score_1++;

            // 2번 수포자 정답 수 카운트
            if(array_2[i % 8] == answers[i])
                score_2++;

            // 3번 수포자 정답 수 카운트
            if(array_3[i % 10] == answers[i])
                score_3++;
        }

        // max 값 찾기
        int max = Math.max(Math.max(score_1, score_2), score_3);

        List<Integer> list = new ArrayList<>();

        if(max == score_1)
            list.add(1);
        if(max == score_2)
            list.add(2);
        if(max == score_3)
            list.add(3);

        result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}

// 문제 : 모의고사
public class PG_mock_test {
    public static void main(String[] args) {
        S_PG_mock_test s = new S_PG_mock_test();

        int[] array = {1, 3, 2, 4, 2};

        for(int num : s.solution(array)) {
            System.out.print(num + " ");
        }
    }
}
