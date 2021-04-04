package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14681 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        //정답
        int quadrant;

        if (x > 0 && y > 0) {
            quadrant = 1;
        } else if (x < 0 && y > 0) {
            quadrant = 2;
        } else if (x < 0 && y < 0) {
            quadrant = 3;
        } else {
            quadrant = 4;
        }

        //출력
        System.out.println(quadrant);
    }
}
