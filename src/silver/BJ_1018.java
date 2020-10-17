package silver;

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

        String[][] matrix = new String[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (int j = 0; j < m; j++) {
                matrix[i][j] = String.valueOf(s.charAt(i));
            }
        }

        //풀이
        String[][] comparisonA = new String[8][8]; //W시작
        String[][] comparisonB = new String[8][8]; //B시작

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(j % 2 == 0) {
                    comparisonA[i][j] = "W";
                    comparisonB[i][j] = "B";
                }
                else {
                    comparisonA[i][j] = "B";
                    comparisonB[i][j] = "W";
                }
            }
        }

        int[][] scoreA = new int[n - 7][m - 7];
        int[][] scoreB = new int[n - 7][m - 7];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < scoreA.length; i++) {
            int countA = 0, countB = 0;
            int indexX = 0, indexY = 0;

            for (int j = 0; j < scoreA[i].length; j++) {
                //체스판 검사
                for (int k = i; k < 7 + i; k++) {
                    for (int l = j; l < 7 + j; l++) {
                        //comparisonA와 대조
                        if (!matrix[k][l].equals(comparisonA[indexX][indexY])) {
                            countA++;
                        }

                        //comparisonB와 대조
                        if (!matrix[k][l].equals(comparisonB[indexX][indexY++])) {
                            countB++;
                        }
                    }
                    indexX++;
                    indexY = 0;
                }

                //min값 초기화
                min = countA < min ? countA : min;
                min = countB < min ? countB : min;

                scoreA[i][j] = countA;
                scoreB[i][j] = countB;
            }
        }

        //출력
        System.out.println(min);
    }
}
