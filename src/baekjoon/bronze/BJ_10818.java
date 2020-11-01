package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        //풀이
        int min = 1000001, max = -1000001;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if(max < num) {
                max = num;
            }

            if (num < min) {
                min = num;
            }
        }

        //출력
        System.out.printf("%d %d", min, max);
    }
}
