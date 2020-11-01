package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603 {
    static int n;
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 풀이 nCr
        while (true) {
            st = new StringTokenizer(br.readLine());

            // 종료
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            // 입력
            arr = new int[n];
            check = new boolean[n];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            combination(0, 0);
            System.out.println();
        }
    }

    public static void combination(int index,int count) {
        if (count == 6) {
            for (int i = 0; i < n; i++) {
                if(check[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = index; i < n; i++) {
            check[i] = true;
            combination(i+1, count+1);
            check[i] = false;
        }
    }
}
