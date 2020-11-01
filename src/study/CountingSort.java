package study;

// 참고 : https://st-lab.tistory.com/104
public class CountingSort {
    public static void main(String[] args) {
        // 배열 3개 필요
        int[] array = new int[100]; // 입력 개수 : 100개
        int[] counting = new int[31]; // 수의 범위 : 0 ~ 30
        int[] result = new int[100]; // 정렬된 결과

        // 1. array 배열에 입력된 수 저장하기
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 31); // 연산 결과 : 0 ~ 30
        }

        // 2. counting 정렬 array 배열의 값으로 초기화
        for (int i = 0; i < array.length; i++) {
            counting[array[i]]++;
        }

        // 3. counting 정렬의 누적합 구하기
        for (int i = 1; i < counting.length; i++) {
            counting[i] += counting[i - 1];
        }

        // 4. array 배열을 뒤에서 부터 반복하며 result 배열에 정렬된 배열 저장하기
        for (int i = array.length - 1; i >= 0; i--) {
            int value = array[i];
            counting[value]--; // 개수 감소
            result[counting[value]] = value;
        }

        // 5. result 배열 출력 (array 배열의 정렬된 형태가 저장되어 있음)
        for (int i = 0; i < result.length; i++) {
            if (i % 10 == 0)
                System.out.println();
            System.out.print(result[i] + " ");
        }
        System.out.println();
        System.out.println();

        // *** counting sort 축약형 ***
        int[] counting_2 = new int[31]; // counting 정렬만 생성

        for (int i = 0; i < 100; i++) {
            counting_2[(int)(Math.random() * 31)]++;
        }

        int count = 0;
        for (int i = 0; i < 31; i++) {
            if(counting_2[i] > 0) { // 값이 하나라도 존재한다면 만족
                while(counting_2[i]-- >= 1) {
                    if(count++ % 10 == 0)
                        System.out.println();
                    System.out.print(i + " ");
                }
            }
        }
    }
}