package baekjoon.silver;

import java.io.*;
import java.util.Arrays;

public class BJ_2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int N = Integer.parseInt(br.readLine());

        int[] al = new int[N];
        for (int i = 0; i < N; i++) {
            al[i] = Integer.parseInt(br.readLine());
        }

        // 풀이
        Arrays.sort(al);

        for (int i = 0; i < N; i++) {
            bw.write(al[i] + "\n");
        }

        bw.flush();
        bw.close();

//        Stream 사용 -> 시간 초과!(bw 사용 안한게 기여했다 생각함)
//
//        ArrayList<Integer> al = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            al.add(Integer.parseInt(br.readLine()));
//        }
//
//        al.stream().sorted().forEach(i -> System.out.println(i));

    }
}
