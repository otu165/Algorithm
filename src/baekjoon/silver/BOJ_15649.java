package baekjoon.silver;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static int[] result;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        result = new int[M];
        visit = new boolean[N]; // false 로 초기화됨

        dfs(N, M, 0);

        // 중복 X + 오름차순 정렬
        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth) {
        if(depth == M) { // 탐색 종료
            for(int num : result)
                sb.append(num + " ");
            sb.append("\n");
            return;
        }

        // 재귀 반복
        for (int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;

                result[depth] = i + 1;
                dfs(N, M, depth + 1);

                visit[i] = false;
            }
        }
    }
}

