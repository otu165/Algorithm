package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ_1182 {
    static int N, S, count = 0;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        array = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        dfs(0, 0);

        System.out.println(S == 0 ? --count : count);
    }

    public static void dfs(int v, int su) {
        if(v == N) {
            if(su == S) { // 합이 S
                count++;
            }
            return;
        }

        // 부분 수열 : 현재 원소를 선택하거나 하지 않거나
        dfs(v + 1, su + array[v]);
        dfs(v + 1, su);
    }
}
