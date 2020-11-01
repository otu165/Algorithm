package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15652 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] result;
    public static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];

        dfs(1, 0);

        // 중복 가능 + 비내림차순 정렬
        System.out.println(sb);
    }

    // 내 직전의 수보다 같거나 커야 함
    public static void dfs(int start, int depth) {
        if(depth == M) {
            for(int i : result)
                sb.append(i + " ");

            sb.append("\n");
            return;
        }

        // 재귀 반복
        for (int i = start; i <= N; i++) {
            result[depth] = i;
            dfs(i, depth+1);
        }
    }
}
