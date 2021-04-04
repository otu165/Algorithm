package study;

// 참고 : https://galid1.tistory.com/507
public class DynamicProgramming {
    public static void main(String[] args) {
        // DP(Dynamic Programming)
        // : 큰 문제를 작은 단위의 문제로 쪼개서 푸는 알고리즘

        // KeyPoint?
        // 규칙 찾기
        // 일반식 찾기

        // DP != 분할정복
        // 분할정복? 작은 부분에서 반복이 일어나지 않음
        // DP? 작은 부분에서 반복(규칙)이 있음

        // Problem_피보나치 문제를 DP 로 해결해보자
        // 1. Bottom-up
        // : 작은 문제부터 시작하는 방법
        System.out.println(fibo_B(6));

        // 2. Top-down
        // : 큰 문제부터 시작하는 방법 (보통 재귀 이용)
        System.out.println(fibo_T(6 - 1));
    }

    private static int fibo_B(int n) {
        // 0, 1, 1, 2, 3, 5, 8 ...

        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else {
            int[] arr = new int[n];
            arr[0] = 0;
            arr[1] = 1;

            for (int i = 2; i < n; i++) {
                arr[i] = arr[i - 1] + arr[i - 2];
            }

            return arr[n - 1];
        }
    }

    private static int fibo_T(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        else
            return fibo_T(n - 1) + fibo_T(n - 2);
    }
}
