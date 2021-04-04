package baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int N, K;
    static int[] road = new int[100001]; // 가능한 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        bfs(N);

        bw.flush();
        bw.close();
    }

    public static void bfs(int start) {
        if(start == K) {
            System.out.println(0);
            System.exit(0);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        road[start] = 1;

        while(!q.isEmpty()) {
            int num = q.poll();

            // 검사할 수 있는 경우의 수
            for (int i = 0; i < 3; i++) {
                int method;

                if(i == 0) {
                    method = num - 1;
                }
                else if(i == 1) {
                    method = num + 1;
                }
                else {
                    method = num * 2;
                }

                if(method == K) {
                    System.out.println(road[num]);
                    return;
                }

                // 가능성 검사
                if(method > 0 && method <= 100000 && road[method] == 0) {
                    q.offer(method);
                    road[method] = road[num] + 1;
                }
            }
        }
    }
}
