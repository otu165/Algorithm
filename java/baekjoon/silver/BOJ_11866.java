package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 (N, K)
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 풀이
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        sb.append("<");
        for(int i = 1; i <= N * K; i++) {
            if(i % K == 0) {
                if(i == N * K)
                    sb.append(q.poll() + ">");
                else
                    sb.append(q.poll() + ", ");
            }
            else
                q.add(q.poll());
        }

        System.out.println(sb);
    }
}
