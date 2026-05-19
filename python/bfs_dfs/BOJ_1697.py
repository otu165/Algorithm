''' 숨바꼭질
시간 : 160ms (~2초), 메모리 : 41516KB (~128MB)
분류 : BFS
제출 : Python3
'''

from collections import deque


def bfs(start):
    q = deque()
    q.append((start, 0))  # 시작 점, 초(sec)

    visited = set()

    while q:
        x, sec = q.popleft()
        operation = [x - 1, x + 1, x * 2]

        for i in range(3):
            nx = operation[i]

            if 0 <= nx <= 100000 and nx not in visited:
                if nx == K:
                    return sec + 1

                if nx <= K + 1:
                    visited.add(nx)
                    q.append((nx, sec + 1))


# 입력
N, K = map(int, input().split())

# 풀이 & 출력
print(N - K if N >= K else bfs(N))
