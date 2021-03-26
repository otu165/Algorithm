package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ_9663 {
    static int N;
    static int[] arr;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueens(0);

        System.out.println(count);
    }

    public static void nQueens(int depth) {
        if(depth == N) {
            count++;
            return;
        }

        // 아직 모든 행을 다 검사하지 못한 경우
        for (int i = 0; i < N; i++) {
            arr[depth] = i;

            if(isValid(depth)) {
                nQueens(depth + 1);
            }
        }
    }

    public static boolean isValid(int depth) {
        for (int i = 0; i < depth; i++) { // 내 윗 행들과 비교
            if(arr[i] == arr[depth] || Math.abs(arr[i] - arr[depth]) == (depth - i)) { // 같은 열에 위치 or 대각선에 위치
                return false;
            }
        }

        return true;
    }
}
