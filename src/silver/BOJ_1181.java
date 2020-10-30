package silver;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class BOJ_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1 <= N <= 20,000
        int N = Integer.parseInt(br.readLine());

        // 중복이 허용되지 않는 collection
        Collection<String> c = new HashSet<>();
        for (int i = 0; i < N; i++) {
            c.add(br.readLine());
        }

        c.stream().sorted((s1, s2) -> {
            if(s1.length() == s2.length())
                return s1.compareTo(s2);
            else
                return s1.length() - s2.length();
        }).forEach(i -> {
            try {
                bw.write(i + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bw.flush();
        bw.close();
    }
}
