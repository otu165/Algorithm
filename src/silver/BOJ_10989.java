package silver;

import java.io.*;
import java.util.Arrays;

public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수의 범위 : 0 ~ 10,000
        // 입력 : N개
        int N = Integer.parseInt(br.readLine());

        // *** Counting Sort 를 이용한 방법 ***
        int[] array = new int[N];
        int[] counting = new int[10001];
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            counting[array[i]]++;
        }

        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }

        for (int i = N - 1; i >= 0; i--) {
            int value = array[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        // 출력
        for (int i = 0; i < result.length; i++) {
            bw.write(result[i] + "\n");
        }


        /* *** Arrays.sort() 를 이용한 방법 ***

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        for (int i = 0; i < N; i++) {
            bw.write(array[i] + "\n");
        }

         */

        bw.flush();
        bw.close();

    }
}
