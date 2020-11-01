package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15649 {
    public static int[] result;
    public static boolean[] visit; // 노드의 방문여부 판단
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new int[M];
        visit = new boolean[N];

        dfs(N, M, 0);

        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) { // 해당 노드 탐색 끝!
            for (int val : result) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) { // 전체 노드 탐색
            if(!visit[i]) { // 방문하지 않은 노드인 경우
                visit[i] = true;
                result[depth] = i + 1;
                dfs(N, M, depth + 1);
                visit[i] = false;
            }
        }
    }
}
