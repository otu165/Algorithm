package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 이분탐색
public class BJ_1920 {
    static int[] arr_a;
    static int[] arr_m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력
        int n = Integer.parseInt(br.readLine());
        arr_a = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        // 2. 입력
        int m = Integer.parseInt(br.readLine());
        arr_m = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr_a);

        // 정답
        for (int i : arr_m) {
            System.out.println(binarySearch(arr_a, i) ? 1 : 0);
        }
    }

    public static boolean binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while(left <= right) {
            mid = (left + right) / 2;

            if(arr[mid] == key) {
                return true;
            }

            if(key < arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return false;
    }
}
