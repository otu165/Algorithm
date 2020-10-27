package study;

// 이진 탐색
// 도움 : https://javaoop.tistory.com/6

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int key = 1;

        System.out.println(binarySearch(arr, key));
    }

    public static int binarySearch(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while(left <= right) { // 아니라면 배열에 존재하지 않는 수
            mid = (left + right) / 2;

            if(key == arr[mid]) {
                return mid;
            }

            if(key < arr[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
