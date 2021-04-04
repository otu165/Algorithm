package baekjoon.bronze;

import java.io.*;

public class BOJ_8958 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();

            int seq = 0;
            int sum = 0;
            for (int j = 0; j < line.length; j++) {
                if(line[j] == 'O') {
                    sum += ++seq;
                } else {
                    seq = 0;
                }
            }

            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}
