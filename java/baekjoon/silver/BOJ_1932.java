package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1932 {
    static int N;
    static int[][] arr;
    static int[][] sum;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        sum = new int[N][];
        visited = new boolean[N][];

        for (int i = 0; i < N; i++) {
            arr[i] = new int[i + 1];
            sum[i] = new int[i + 1];
            visited[i] = new boolean[i + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(dp() + "");

        bw.flush();
        bw.close();
    }

    private static int dp() { // 왼쪽 : 인덱스 동일, 오른쪽 : 인덱스 + 1
        sum[0][0] = arr[0][0];

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // 왼쪽값 넣기
                int value = sum[i][j] + arr[i + 1][j];

                if (visited[i + 1][j]) { // 첫방문 X
                    if (sum[i + 1][j] < value)
                        sum[i + 1][j] = value;

                } else { // 첫방문 O
                    visited[i + 1][j] = true;

                    sum[i + 1][j] = value;
                }

                // 오른쪽값 넣기
                value = sum[i][j] + arr[i + 1][j + 1];

                if (visited[i + 1][j + 1]) { // 첫방문 X
                    if (arr[i + 1][j + 1] < value)
                        sum[i + 1][j + 1] = value;

                } else { // 첫방문 O
                    visited[i + 1][j + 1] = true;

                    sum[i + 1][j + 1] = value;
                }
            }
        }

        // 최댓값 찾기
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (max < sum[N - 1][i])
                max = sum[N - 1][i];
        }

        return max;
    }
}
