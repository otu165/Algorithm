package study;

// 조합 : nCr = n-1Cr-1 + n-1Cr
// 도움 : https://gorakgarak.tistory.com/523?category=265216
public class Combination {
    public static void main(String[] args) {
        int[] arr = new int[5];
        combination(arr, 0, 10, 3, 0);
    }

    /*
    // 기본 아이디어
    public static int combination(int n, int r) {
        if(n == r || r == 0)
            return 1;
        else
            return combination(n - 1, r - 1)
                    + combination(n - 1, r);
    }
    */

    // index : 하나가 정해졌으면 + 1, 이와 동시에 r-1 인자 주어야 함
    // index 가 정해지지 않았다면, 배열에 값이 들어가지 않았으므로 index, r 그대로
    // target : 어떤 숫자를 타겟으로 하여 배열에 넣을까, 즉 항상 +1 해야 함
    public static void combination(int[] arr, int index, int n, int r, int target) {
        if(r == 0) { // 모든 숫자가 정해짐
            print(arr, index);
        }
        else if (target == n) {
            return;
        }
        else {
            arr[index] = target;
            combination(arr, index + 1, n, r-1, target + 1);
            combination(arr, index, n, r, target+1);
        }
    }

    public static void print(int[] arr, int index) {
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
