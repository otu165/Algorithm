package silver;

import java.io.*;
import java.util.Arrays;

public class BOJ_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        char[] array = br.readLine().toCharArray();

        Arrays.sort(array);

        for (int i = array.length - 1; i >= 0; i--) {
            bw.write(array[i]);
        }

        bw.flush();
        bw.close();
    }
}
