package study;

// 참고 : https://st-lab.tistory.com/104
public class CountingSort {
    public static void main(String[] args) {
        // *** counting 배열의 동작 원리 ***

        // 입력
        int[] array = new int[100]; // 수열의 원소 : 100개
        int[] counting = new int[31]; // 수의 범위 : 0 ~ 30
        int[] result = new int[100]; // 정렬 될 배열

        // 풀이
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 31); // 0 ~ 30
        }

        // 1. array 의 값을 index 로 하는 counting 배열 값 증가
        for (int i = 0; i < array.length; i++) {
            counting[array[i]]++;
        }

        // 2. counting 배열 누적 합 구하기
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i-1];
        }

        // 3. array 배열을 뒤에서부터 검사하며 result 배열에 값 저장하기
        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        // 출력
        for (int i = 0; i < result.length; i++) {
            if(i % 10 == 0) {
                System.out.println();
            }
            System.out.print(result[i] + " ");
        }
        System.out.println();
        System.out.println();

        // *** array + counting + result 축약형 ***

        // 입력
        int[] arr = new int[101]; // 수의 범위 : 0 ~ 100
        for (int i = 0; i < 50; i++) { // 입력 개수 : 50개
            arr[(int)(Math.random()*101)]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]-- > 0) {
                System.out.print(i + " ");
            }
        }
    }
}
