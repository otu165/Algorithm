package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static int[][] graph;

    static boolean[] dfs_isVisit;
    static StringBuilder dfs_sb = new StringBuilder();

    static boolean[] bfs_isVisit;
    static StringBuilder bfs_sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색 시작 정점

        graph = new int[N + 1][N + 1];
        dfs_isVisit = new boolean[N + 1];
        bfs_isVisit = new boolean[N + 1];

        // draw graph
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(V);
        System.out.println(dfs_sb);

        bfs(V);
    }

    private static void dfs(int turn) {
        dfs_isVisit[turn] = true;
        dfs_sb.append(turn + " ");

        for (int i = 1; i < graph.length; i++) {
            if(graph[turn][i] == 1 && !dfs_isVisit[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        bfs_sb.append(start + " ");

        bfs_isVisit[start] = true;

        while(!q.isEmpty()) {
            int turn = q.poll();

            for (int i = 1; i < graph.length; i++) {
                if(graph[turn][i] == 1 && !bfs_isVisit[i]) { // 연결되어 있다면
                    q.offer(i);
                    bfs_isVisit[i] = true;
                    bfs_sb.append(i + " ");
                }
            }
        }

        System.out.println(bfs_sb);
    }
}
