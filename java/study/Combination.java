package study;

// 조합 : nCr = n-1Cr-1 + n-1Cr
// 도움 : https://gorakgarak.tistory.com/523?category=265216

public class Combination {
    public static int[] source;

    public static void main(String[] args) {
        int[] arr = new int[5];
        source = new int[5];

        for (int i = 0; i < 5; i++) {
            source[i] = 2 * i + 1;
        }

        combination(arr, 5, 4, 0, 0);
    }

    // index : 정해지면 r - 1, 아니면 r
    // target : 배열에 넣을 수 탐색, 즉 항상 target + 1
    public static void combination(int[] arr, int n, int r, int index, int target) {
        if(r == 0) { // 종료 조건
            print(arr, index);
        }
        else if (target == n) { // 적합한 케이스 없음
            return;
        }
        else {
            arr[index] = source[target]; // 배열에 저장되는 값 조정 가능
            combination(arr, n, r - 1, index + 1, target+1);
            combination(arr, n, r, index, target+1);
        }
    }

    public static void print(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            if(i == length - 1) {
                System.out.println(arr[i]);
            }
            else
                System.out.print(arr[i] + ",");
        }
    }
}