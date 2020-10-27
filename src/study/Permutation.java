package study;

// 순열 : nPr
// 도움 : https://gorakgarak.tistory.com/522?category=265216
public class Permutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        permutation(array, 0, 4, 3);
    }

    public static void permutation(int[] arr, int depth, int n, int r) {
        if(depth == r) { // 한 줄 출력
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            permutation(arr, depth+1, n, r);
            swap(arr, i, depth);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr, int r) {
        for (int i = 0; i < r; i++) {
            if(i == r - 1) {
                System.out.println(arr[i]);
            }
            else {
                System.out.print(arr[i] + ",");
            }
        }
    }
}
