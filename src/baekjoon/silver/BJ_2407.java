package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.math.*;

public class BJ_2407 {
    static BigInteger[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 풀이 nCm
        arr = new BigInteger[n + 1][m + 1];
        System.out.println(combination(n, m));
    }

    public static BigInteger combination(int n, int m) {
        if (n == m || m == 0) {
            return BigInteger.ONE;
        }
        if(arr[n][m] != null) {
            return arr[n][m];
        }
        arr[n][m] = new BigInteger("0");

        return arr[n][m] = arr[n][m]
                .add(combination(n-1,m-1))
                .add(combination(n-1, m));
    }
}
