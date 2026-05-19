''' 아기 상어
시간 : (2초), 메모리 : (512MB)
분류 : bfs
참고 : https://inspirit941.tistory.com/207

heapq 를 이용하여 최솟값에 우선순위를 줄 수 있다.
'''

import sys
import heapq
from collections import deque
read = sys.stdin.readline


def bfs(start, size):  # 먹을 물고기 찾음
    x, y, time = start
    arr[x][y] = 0  # 해당 위치 물고기 먹음

    q = deque()
    q.append(start)

    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]

    fish = []
    visited = set()

    while q:
        x, y, time = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < N and 0 <= ny < N:
                if (nx, ny) not in visited:
                    visited.add((nx, ny))  # 방문 처리

                    '''
                    자신보다 큰 물고기 : 먹을 수 없고 지나갈 수 없음
                    자신과 동일한 크기 : 먹을 수 없지만 지나갈 수 있음
                    자신보다 작은 물고기 : 먹을 수 있음
                    '''

                    # 1. 먹을 수 없음
                    if arr[nx][ny] > size:
                        continue

                    # 2. 지나갈 수만 있음
                    if arr[nx][ny] == 0 or arr[nx][ny] == size:
                        q.append((nx, ny, time + 1))
                        continue

                    # 3. 먹을 수 있음
                    heapq.heappush(fish, (time + 1, nx, ny))  # 시간, 행, 열 순으로 오름차순 정렬됨

    if fish:
        return fish[0]
    else:
        return None


# 입력
N = int(read())
arr = [list(map(int, read().split())) for _ in range(N)]

# 풀이
for i in range(N):
    for j in range(N):
        if arr[i][j] == 9:
            start = (i, j, 0)  # 시작 좌표 : x, y, 시간(초)

size, ate, answer = 2, 0, 0  # 상어 크기, 먹은 물고기, 시간(초)
while True:
    fish = bfs(start, size)

    if fish is None:  # 종료 조건
        break

    time, nx, ny = fish
    start = (nx, ny, 0)

    answer += time  # 시간 +
    ate += 1  # 먹은 물고기 +
    if size == ate:  # size +
        ate = 0
        size += 1

# 출력
print(answer)

