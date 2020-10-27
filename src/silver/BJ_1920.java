package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분탐색
public class BJ_1920 {
    static int[] arr_a;
    static int[] arr_m;
    static boolean[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력
        int n = Integer.parseInt(br.readLine());
        arr_a = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        // 2. 입력
        int m = Integer.parseInt(br.readLine());
        arr_m = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        // arr_m 의 수들이 arr_a 에 존재하는가?
        result = new boolean[m];

        Arrays.stream(arr_a).sorted();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr_a[j] == arr_m[i]) {
                    result[i] = true;
                    break;
                }
            }
        }

        print(result, m);
    }

    public static void print(boolean[] result, int m) {
        for (int i = 0; i < m; i++) {
            System.out.println(result[i] ? 1 : 0);
        }
    }
}
