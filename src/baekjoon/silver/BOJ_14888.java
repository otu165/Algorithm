package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14888 {
    static int N;
    static int[] arr; // 수
    static int[] op; // 연산자
    static int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[st.countTokens()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result = arr[0];

        st = new StringTokenizer(br.readLine());
        op = new int[4];

        for (int i = 0; i < op.length; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        System.out.println(max + "\n" + min);
    }

    private static void dfs(int result, int depth) {
        if(depth == N) {
            if(result < min)
                min = result;
            if(max < result)
                max = result;

            return;
        }

        for (int i = 0; i < 4; i++) {
            if(op[i] > 0) {
                op[i]--;

                if(i == 0) { // 덧셈
                    dfs(result + arr[depth], depth + 1);
                }
                else if(i == 1) { // 뺄셈
                    dfs(result - arr[depth], depth + 1);
                }
                else if(i == 2) { // 곱셈
                    dfs(result * arr[depth], depth + 1);

                }
                else { // 나눗셈
                    dfs(result / arr[depth], depth + 1);
                }

                op[i]++;
            }
        }
    }
}
