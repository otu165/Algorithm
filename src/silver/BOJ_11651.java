package silver;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            matrix[i][1] = Integer.parseInt(st.nextToken());
            matrix[i][0] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(matrix, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });

        for (int i = 0; i < N; i++) {
            bw.write(matrix[i][1] + " " + matrix[i][0] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
