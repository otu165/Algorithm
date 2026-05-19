''' 치즈
시간 : 156ms (~1초), 메모리 : 33000KB (~128MB)
분류 : BFS
제출 : Python3
'''

import sys
from collections import deque
input = sys.stdin.readline


def count():
    cnt = 0
    for x in range(H):
        for y in range(W):
            if arr[x][y] == 1:
                cnt += 1

    return cnt


def bfs():
    q = deque()
    q.append((0, 0))

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    visited = [[0] * W for _ in range(H)]

    remove = []

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < H and 0 <= ny < W:
                if visited[nx][ny] == 0 and arr[nx][ny] == 0:  # 방문할 노드
                    visited[nx][ny] = 1
                    q.append((nx, ny))
                elif arr[nx][ny] == 1:  # 녹을 치즈
                    remove.append((nx, ny))

    for x, y in remove:
        arr[x][y] = 0


# 입력
H, W = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(H)]  # 치즈 : 1, 없음 : 0

# 풀이
answer = 0
history = []

while True:
    history.append(count())

    # 종료 조건
    if history[-1] == 0:
        break

    bfs()
    answer += 1


# 출력
print(answer)
print(history[-2])



