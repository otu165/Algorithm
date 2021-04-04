package programmers.level_1;

import java.util.Arrays;

class S_PG_number_k {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // i-1 ~ j-1 배열 추출, 정렬 후 k-1 인덱스의 값

        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];

            int[] arr = new int[j - i + 1];

            for (int m = 0; m < arr.length; m++) {
                arr[m] = array[i + m - 1];
            }

            Arrays.sort(arr);

            answer[n] = arr[k-1];
        }

        return answer;
    }
}

public class PG_number_k {
    public static void main(String[] args) {
        S_PG_number_k s = new S_PG_number_k();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        for(int num : s.solution(array, commands)) {
            System.out.print(num + " ");
        }
    }
}
