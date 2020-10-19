package silver;

import java.io.*;

public class BJ_2447 {
    public static char[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int n = Integer.parseInt(br.readLine());

        // 풀이
        matrix = new char[n][n];
        fillMatrix(0, 0, n, false);

        // 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(matrix[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void fillMatrix(int x, int y, int n, boolean flag) { // x, y : 좌표, n : 블록의 길이, flag : 공백 여부
        if(flag) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    matrix[i][j] = ' ';
                }
            }

            return;
        }

        if(n == 1) {
            matrix[x][y] = '*';

            return;
        }
        
        // 블록이 더 나누어지는 경우
        int size = n / 3;
        int count = 0; // count = 5인 경우, 공백에 해당함

        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                count++;

                fillMatrix(i, j, size, count == 5);
            }
        }
    }
}