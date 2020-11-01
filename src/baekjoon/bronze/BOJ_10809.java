package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력 저장
        char alphabet[] = br.readLine().toCharArray();

        //정답 저장
        int answer[] = new int[26];
        Arrays.fill(answer, -1);

        //비교군, ASCII 코드 이용(a = 97, z = 122)
        int compare[] = new int[26];
        for (int i = 0; i < compare.length; i++) {
            compare[i] = 97 + i;
        }

        for (int i = 0; i < alphabet.length; i++) {
            int ascii = (int)alphabet[i];

            for (int j = 0; j < compare.length; j++) {
                if((answer[j] == -1) && (ascii == compare[j])) {
                    answer[j] = i;
                }
            }
        }

        //출력
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}