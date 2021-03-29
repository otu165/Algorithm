import sys
from collections import deque


def bfs():
    result = [[-1] * M for _ in range(N)]
    result[0][0] = 0  # 출발점

    queue = deque()
    queue.append([0, 0])

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            xx = x + dx[i]
            yy = y + dy[i]

            if (0 <= xx < M) and (0 <= yy < N):
                if result[yy][xx] == -1:
                    if maze[yy][xx] == '1':  # 부수고 이동
                        queue.append([xx, yy])
                        result[yy][xx] = result[y][x] + 1
                    else:  # 그냥 이동
                        queue.appendleft([xx, yy])
                        result[yy][xx] = result[y][x]

    return result[N-1][M-1]


# 입력
input = sys.stdin.readline

M, N = map(int, input().split())  # 가로, 세로
maze = [input().rstrip() for _ in range(N)]

# 풀이
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

# 출력
print(bfs())