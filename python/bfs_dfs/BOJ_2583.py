''' 영역 구하기
시간 : 100ms (~1초), 메모리 : 38416KB (~128MB)
분류 : DFS
제출 : Python3
'''

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]


def dfs(x, y, cnt):
    arr[x][y] = 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < M and 0 <= ny < N:
            if arr[nx][ny] == 0:
                cnt = dfs(nx, ny, cnt + 1)

    return cnt


M, N, K = map(int, input().split())  # 세로, 가로, 직사각형 개수
arr = [[0] * N for _ in range(M)]  # 모눈종이

for i in range(K):
    ly, lx, ry, rx = map(int, input().split())  # 왼쪽 아래 꼭짓점, 오른쪽 위 꼭짓점
    '''
    상하대칭 가정
    1. 왼쪽 아래 꼭짓점 -> 왼쪽 위 꼭짓점
    2. 오른쪽 위 꼭짓점 -> 오른쪽 아래 꼭짓점
    '''

    for x in range(lx, rx):
        for y in range(ly, ry):
            arr[x][y] = 1

answer = []
for x in range(M):
    for y in range(N):
        if arr[x][y] == 0:
            answer.append(dfs(x, y, 1))

# 출력
print(len(answer))
print(*sorted(answer))




