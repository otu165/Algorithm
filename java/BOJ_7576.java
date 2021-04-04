package baekjoon.silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BOJ_7576 {
    static int[][] matrix;
    static int[] dx = {1, -1, 0, 0}; // 동서남북
    static int[] dy = {0, 0, 1, -1}; // 동서남북
    static Queue<Point> q = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        matrix = new int[N][M];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                sum += matrix[i][j];

                if(matrix[i][j] == 1)
                    q.offer(new Point(i, j));
            }
        }

        if(sum == N * M) {
            System.out.println(0);
        }
        else {
            bfs(M, N);
            System.out.println(count);
        }
    }

    private static void bfs(int M, int N) { // 가로, 세로
        while(!q.isEmpty()) {
            Point target = q.poll(); // 현재 검사할 타겟

            for (int i = 0; i < dx.length; i++) { // 타겟의 동서남북 검사
                int x = target.x + dx[i];
                int y = target.y + dy[i];

                if(x >= 0 && x < N && y >= 0 && y < M) { // 범위 내?
                    if(matrix[x][y] == 0) { // 익을 토마토?
                        matrix[x][y] = matrix[target.x][target.y] + 1;
                        q.offer(new Point(x, y));
                    }
                }
            }
        }

        // 최댓값? + 0 값을 가진 칸이 있다면 모두 익지 못하는 상황
        int max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int[] x : matrix) {
            for(int y : x) {
                if(y == 0) {
                    flag = true;
                    break;
                }

                max = Math.max(max, y);
            }
        }

        if(flag)
            count = -1;
        else
            count = max - 1;

    }
}