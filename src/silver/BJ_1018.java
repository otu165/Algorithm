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

        //풀이
        String[][] matrix = new String[n][m];

        int[][] comparisonA = new int[n][m]; //WBWB + BWBW
        int[][] comparisonB = new int[n][m]; //BWBW + WBWB
        initializeComparison(br, comparisonA, comparisonB);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {

                //체스판의 합
                if (getSum(comparisonA, comparisonB, i, j) < min) {
                    min = getSum(comparisonA, comparisonB, i, j);
                }
            }
        }

        //출력
        System.out.println(min);
    }

    public static void initializeComparison(BufferedReader br, int[][] comparisonA, int[][] comparisonB) throws IOException{
        for (int i = 0; i < comparisonA.length; i++) {
            String s = br.readLine();

            for (int j = 0; j < comparisonA[i].length; j++) {
                //A : 같으면 0, 다르면 1
                //B : 같으면 0, 다르면 1
                String word = String.valueOf(s.charAt(j));

                if (i % 2 == 0) {
                    if (j % 2 == 0) { //짝 + 짝
                        if(word.equals("W")) {
                            comparisonA[i][j] = 0;
                            comparisonB[i][j] = 1;
                        }
                        else {
                            comparisonA[i][j] = 1;
                            comparisonB[i][j] = 0;
                        }
                    }
                    else { //짝 + 홀
                        if (word.equals("B")) {
                            comparisonA[i][j] = 0;
                            comparisonB[i][j] = 1;
                        }
                        else {
                            comparisonA[i][j] = 1;
                            comparisonB[i][j] = 0;
                        }
                    }
                }
                else {
                    if (j % 2 == 0) { //홀 + 짝
                        if (word.equals("B")) {
                            comparisonA[i][j] = 0;
                            comparisonB[i][j] = 1;
                        }
                        else {
                            comparisonA[i][j] = 1;
                            comparisonB[i][j] = 0;
                        }
                    }
                    else { //홀 + 홀
                        if(word.equals("W")) {
                            comparisonA[i][j] = 0;
                            comparisonB[i][j] = 1;
                        }
                        else {
                            comparisonA[i][j] = 1;
                            comparisonB[i][j] = 0;
                        }
                    }
                }
            }
        }
    }

    public static int getSum(int[][] comparisonA, int[][] comparisonB, int x, int y) {
        int sumA = 0, sumB = 64;

        for (int i = x; i < 8 + x; i++) {
            for (int j = y; j < 8 + y; j++) {
                sumA += comparisonA[i][j];
                sumB -= comparisonB[i][j];
            }
        }

        return sumA < sumB ? sumA : sumB;
    }
}
