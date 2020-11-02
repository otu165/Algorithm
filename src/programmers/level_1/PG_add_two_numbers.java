package programmers.level_1;

import java.util.HashSet;
import java.util.Set;

class s_PG_add_two_numbers {
    public int[] solution(int[] numbers) {
        // 만들 수 있는 모든 수 오름차순 정렬

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                s.add(numbers[i] + numbers[j]);
            }
        }

        return s.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}

public class PG_add_two_numbers {
    public static void main(String[] args) {
        s_PG_add_two_numbers s = new s_PG_add_two_numbers();

        int[] array = {2, 1, 3, 4, 1};
        for(int num : s.solution(array)) {
            System.out.print(num + " ");
        }
    }
}
