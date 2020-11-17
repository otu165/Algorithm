package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4963 {

    static int[][] matrix;
    static boolean[][] visit;

    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {1, 1, 1, 0, 0, -1, -1, -1};

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 섬의 개수를 세는 프로그램
        while(true) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken()); // 지도의 너비
            int h = Integer.parseInt(st.nextToken()); // 지도의 높이

            if(w == 0 && h == 0) // 종료
                break;

            // 지도 입력받기
            matrix = new int[w][h];
            visit = new boolean[w][h];

            for (int i = 0; i < h; i++) { // 1 : 땅, 0 : 바다
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    matrix[j][i] = Integer.parseInt(st.nextToken());
                    visit[j][i] = matrix[j][i] == 0;
                }
            }

            // h 개의 지도
            // 가로 세로 또는 대각선 연결 : 걸어갈 수 있는 사각형
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if(!visit[i][j] && matrix[i][j] == 1) {
                        dfs(i, j, w, h);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
            count = 0;
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int w, int h) {

        for (int i = 0; i < dx.length; i++) {
            // 걸어갈 수 있는 블럭이 있는지 확인
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx >= 0 && xx < w && yy >= 0 && yy < h) {
                if(matrix[xx][yy] != 0 && !visit[xx][yy]) {
                    visit[xx][yy] = true;
                    dfs(xx, yy, w, h);
                }
            }
        }
    }
}
