''' 움직이는 미로 탈출
시간 : (~2초), 메모리 : (~512MB)
분류 : BFS
제출 : Python3
'''

import sys
from collections import deque
input = sys.stdin.readline


def bfs(x, y):
    q = deque()
    q.append((x, y, 0))  # x, y, 시간

    dx = [-1, -1, -1, 0, 0, 0, 1, 1, 1]
    dy = [-1, 0, 1, -1, 0, 1, -1, 0, 1]

    while q:
        x, y, time = q.popleft()

        for i in range(9):
            nx = x + dx[i]
            ny = y + dy[i]

            # 현재 벽 위치
            if 0 <= nx < 8 and 0 <= ny < 8:
                present_wall = list(filter(lambda a: 0 <= a[0] < 8 and 0 <= a[1] < 8,
                                           list((map(lambda a: (a[0] + time, a[1]), wall)))))
                if (nx, ny) not in present_wall:  # 이동하려는 곳이 벽이 아님
                    # 캐릭터의 위치 == 벽 위치라면 게임 오버
                    moved_wall = list(filter(lambda a: 0 <= a[0] < 8 and 0 <= a[1] < 8,
                                             list((map(lambda a: (a[0] + time + 1, a[1]), wall)))))
                    if (nx, ny) in moved_wall:
                        continue
                    # 만약 모든 벽이 나보다 아래에 있으면 게임 끝
                    if len(list(filter(lambda a: a[0] > nx, moved_wall))) == len(moved_wall):
                        return 1
                    # 도착했으면 게임 끝
                    if nx == 0 and ny == 1:
                        return 1

                    q.append((nx, ny, time + 1))

    return 0  # 이동 불가


# 입력
arr = []
wall = []
for i in range(8):
    line = list(input().strip())
    for idx, val in enumerate(line):
        if val == '#':
            wall.append((i, idx))
    arr.append(line)

# 풀이 & 출력
print(bfs(7, 0))
