package baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static int[][] graph;
    static boolean[] isVirus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int P = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수

        graph = new int[N + 1][N + 1];
        isVirus = new boolean[N + 1];

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        bfs(1);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>(); // 바이러스에 걸린 컴퓨터
        q.offer(start);

        isVirus[start] = true;
        int count = 0;

        while(!q.isEmpty()) {
            int turn = q.poll();

            for (int i = 1; i < graph.length; i++) {
                if(graph[turn][i] == 1 && !isVirus[i]) {
                    isVirus[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
