package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //입력
        int n = Integer.parseInt(br.readLine());

        //출력
        System.out.println(fact(n));
    }

    public static int fact(int n) {
        if(n < 2) {
            return 1;
        }
        else {
            return n * fact(n-1);
        }
    }
}
