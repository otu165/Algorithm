package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ_2447 {
    public static String matrix[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());

        //풀이
        matrix = new String[n][n];
        getMatrix(n, 0, n, 0);

        // 출력
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void getMatrix(int n, int beginIdx, int endIdx, int y) {
        if(n == 3) {
            for (int i = y; i < y + (endIdx - beginIdx); i++) {
                for (int j = beginIdx; j < endIdx; j++) {
                    matrix[i][j] = "*";
                }
            }

            matrix[y+1][beginIdx+1] = matrix[y+1][beginIdx+1].replace("*", " ");
            return;
        }
        else {

            int idx = n / 3;

            // 1.
            getMatrix(idx, 0, idx, 0);
            getMatrix(idx, idx, idx * 2, 0);
            getMatrix(idx, idx * 2, idx * 3, 0);

            // 2.
            getMatrix(idx, 0, idx, idx);

            for (int i = idx; i < idx * 2; i++) {
                for (int j = idx; j < idx * 2; j++) {
                    matrix[i][j] = " ";
                }
            }

            getMatrix(idx, idx * 2, idx * 3, idx);

            // 3.
            getMatrix(idx, 0, idx, idx * 2);
            getMatrix(idx, idx, idx * 2, idx * 2);
            getMatrix(idx, idx * 2, idx * 3, idx * 2);
        }
    }
}
