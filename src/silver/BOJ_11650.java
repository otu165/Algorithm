package silver;

import java.io.*;
import java.util.*;

public class BOJ_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1 <= N <= 100,000
        // -10,000 <= x, y <= 100,000
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (arr1, arr2) -> {
            if(arr1[0] == arr2[0])
                return arr1[1] - arr2[1];
            else
                return arr1[0] - arr2[0];
        });

        for (int i = 0; i < N; i++) {
            bw.write(array[i][0] + " " + array[i][1] + "\n");
        }

        bw.flush();
        bw.close();

    }
}
