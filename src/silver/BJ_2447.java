package silver;

import java.io.*;

public class BJ_2447 {
    public static String matrix[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int n = Integer.parseInt(br.readLine());

        //풀이
        matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = String.valueOf(i + j);
            }
        }


        // 출력
//        for (int i = 0; i < n; i++) {
//            bw.write(matrix[i]); //안되는데
//            bw.write("\n");
//        }

        bw.flush();
        bw.close();
    }

    public static void getMatrix() {

    }
}
