package silver;

import java.io.*;
import java.util.*;

public class BOJ_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[][] array = new String[N][2];

        // 나이 증가순
        // 나이가 같다면, 먼저 가입한 사람 순
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split(" ");

            array[i][0] = s[1];
            array[i][1] = s[0];
        }

        Arrays.sort(array, (s1, s2) -> {
            if(Integer.parseInt(s1[1]) > Integer.parseInt(s2[1]))
                return 1;
            else if (Integer.parseInt(s1[1]) < Integer.parseInt(s2[1]))
                return -1;
            else
                return 0;

        });

        for (int i = 0; i < N; i++) {
            bw.write(array[i][1] + " " + array[i][0] + "\n");
        }

        bw.flush();
        bw.close();

    }
}
