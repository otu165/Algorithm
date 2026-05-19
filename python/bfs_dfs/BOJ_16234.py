''' 인구 이동
시간 : 1440ms (~2초), 메모리 : 144928KB (~512MB)
분류 : bfs
제출 : pypy3
'''

import sys
from collections import deque

input = sys.stdin.readline


def bfs(i, j):
    q = deque()
    q.append((i, j))
    visited[i][j] = 1

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    union = [(i, j)]  # 연합
    people = arr[i][j]

    while q:
        x, y = q.popleft()
        population = arr[x][y]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                if visited[nx][ny] == 0 and L <= abs(arr[nx][ny] - population) <= R:
                    visited[nx][ny] = 1
                    q.append((nx, ny))
                    union.append((nx, ny))
                    people += arr[nx][ny]

    if len(union) == 1:
        return 0

    avg = people // len(union)
    for x, y in union:
        arr[x][y] = avg

    return 1


# 입력
N, L, R = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# 풀이
answer = 0
while True:
    visited = [[0] * N for _ in range(N)]

    move = 0
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0:
                move += bfs(i, j)

    if move == 0:
        break

    answer += 1

# 출력
print(answer)
