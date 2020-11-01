package study;

// 순열 : nPr
// 도움 : https://gorakgarak.tistory.com/522?category=265216
public class Permutation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        permutation(array, array.length, 2, 0);
    }

    public static void permutation(int[] arr, int n, int r, int depth) {
        if (depth == r) { // 종료 조건
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            permutation(arr, n, r, depth+1);
            swap(arr, i, depth);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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