package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //풀이
        int totalMinute = (h * 60 + m) - 45 < 0 ? 24 * 60 + m - 45 : (h * 60 + m) - 45;

        int hour = totalMinute / 60;
        int minute = totalMinute - (hour * 60);

        //출력
        System.out.printf("%d %d", hour, minute);

    }
}
