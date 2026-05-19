''' 미로 탐색
시간 : 116ms (~1초), 메모리 : 31900KB (~192MB)
분류 : BFS
제출 : Python3
'''

import sys
from collections import deque
input = sys.stdin.readline


def bfs():  # 목적지 : (N-1, M-1)
    q = deque()
    q.append((0, 0, 1))  # x, y, dist
    arr[0][0] = 0

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    while q:
        x, y, dist = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < M:
                if arr[nx][ny] == 1:
                    arr[nx][ny] = dist + 1  # 방문처리
                    if nx == N - 1 and ny == M - 1:
                        return

                    q.append((nx, ny, dist + 1))


# 입력
N, M = map(int, input().split())
arr = [list(map(int, input().rstrip())) for _ in range(N)]

# 풀이
bfs()

# 출력
print(arr[N - 1][M - 1])
