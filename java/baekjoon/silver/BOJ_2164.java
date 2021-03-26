package baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        // 풀이
        for (int i = 0; i < N; i++) {
            if(q.size() == 1) {
                break;
            }

            q.poll();

            q.offer(q.poll());
        }

        // 출력
        System.out.println(q.peek());
    }
}
