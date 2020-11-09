package baekjoon.silver;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int N, M;
    static int[] dx = {1, -1, 0, 0}; // 동서남북
    static int[] dy = {0, 0, -1, 1};
    static char[][] matrix;
    static int[][] count;
    static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix = new char[N][];
        count = new int[N][M];
        isVisit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            matrix[i] = br.readLine().toCharArray();
        }

        // (0, 0) 방문
        count[0][0] = 1;
        bfs(0, 0);

        bw.write(count[N-1][M-1] + "");

        bw.flush();
        bw.close();
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y});

        while(!q.isEmpty()) {
            int[] next = q.poll();
            isVisit[x][y] = true;

            for (int i = 0; i < 4; i++) { // 동서남북 검사
                int nextX = next[0] + dx[i];
                int nextY = next[1] + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M) {
                    if(!isVisit[nextX][nextY] && matrix[nextX][nextY] == '1') {
                        // 해당 노드 방문 가능
                        q.offer(new int[] {nextX, nextY});
                        isVisit[nextX][nextY] = true;
                        count[nextX][nextY] = count[next[0]][next[1]] + 1;
                    }
                }
            }
        }
    }
}
