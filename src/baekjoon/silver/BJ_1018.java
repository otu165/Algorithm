package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //풀이
        char[][] matrix = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                int b = getDifferenceB(matrix, i, j);
                int w = getDifferenceW(matrix, i, j);

                int min_2 = b > w ? w : b;
                min = min > min_2 ? min_2 : min;
            }
        }

        //출력
        System.out.println(min);
    }

    private static int getDifferenceB(char[][] matrix, int i, int j) {

        int count = 0;

        for (int n = 0; n < 8; n++) {
            for (int m = 0; m < 8; m++) {
                // BW 01
                // WB 23

                if(n % 2 == 0) {
                    if (m % 2 == 0) { // B, 3
                        if(matrix[i+n][j+m] != 'B')
                            count++;
                    }
                    else { // W, 2
                        if(matrix[i+n][j+m] != 'W')
                            count++;
                    }
                }
                else {
                    if (m % 2 == 0) { // W, 1
                        if(matrix[i+n][j+m] != 'W')
                            count++;
                    }
                    else { // B, 0
                        if(matrix[i+n][j+m] != 'B')
                            count++;
                    }
                }
            }
        }

        return count;
    }

    private static int getDifferenceW(char[][] matrix, int i, int j) {

        int count = 0;

        for (int n = 0; n < 8; n++) {
            for (int m = 0; m < 8; m++) {
                // WB 01
                // BW 23

                if(n % 2 == 0) {
                    if (m % 2 == 0) { // W, 3
                        if(matrix[i+n][j+m] != 'W')
                            count++;
                    }
                    else { // B, 2
                        if(matrix[i+n][j+m] != 'B')
                            count++;
                    }
                }
                else {
                    if (m % 2 == 0) { // B, 1
                        if(matrix[i+n][j+m] != 'B')
                            count++;
                    }
                    else { // W, 0
                        if(matrix[i+n][j+m] != 'W')
                            count++;
                    }
                }
            }
        }

        return count;
    }
}
