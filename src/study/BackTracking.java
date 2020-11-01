package study;

public class BackTracking {
    public static void main(String[] args) {
        // 백트래킹 (완전 탐색에 포함됨)
        // 주로 재귀, dfs(깊이 우선 탐색) 과 함께 사용됨

        // 원리?
        // 1. 특정 노드의 유망성 검사
        // 2. 유망하지 않으면 검사하지 않음
        // 3. 부모 노드로 돌아간 후 다른 자식 노드 검사

        // dfs 로 구현하면 bfs 보다 적은 메모리가 사용됨

        int[] arr = new int[5];
        dfs(arr, 5, 3, 0);

        // start 인수를 주어, 중복을 제거할 수 있음
        // visit 인수를 추가하여, 노드의 유망성을 검사할수 있음
    }

    public static void dfs(int[] arr, int N, int M, int depth) {
        if(depth == M) { // 종료 조건
            // print arr
            return;
        }

        for (int i = 0; i < N; i++) {
            // 재귀 + 반복 조건
        }
    }
}
