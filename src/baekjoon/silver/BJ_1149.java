package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //입력
        int n = Integer.parseInt(br.readLine());
        int matrix[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //풀이
        int valueMatrix[][] = new int[n][3];

        valueMatrix[0][0] = matrix[0][0];
        valueMatrix[0][1] = matrix[0][1];
        valueMatrix[0][2] = matrix[0][2];

        for (int i = 1; i < n; i++) {
            valueMatrix[i][0] = matrix[i][0] + Math.min(valueMatrix[i - 1][1], valueMatrix[i - 1][2]);
            valueMatrix[i][1] = matrix[i][1] + Math.min(valueMatrix[i - 1][0], valueMatrix[i - 1][2]);
            valueMatrix[i][2] = matrix[i][2] + Math.min(valueMatrix[i - 1][0], valueMatrix[i - 1][1]);
        }

        //출력
        int minValue = Math.min(Math.min(valueMatrix[n-1][0], valueMatrix[n-1][1]), valueMatrix[n-1][2]);
        System.out.println(minValue);
   }
}
