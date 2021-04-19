''' 단지번호붙이기

시간 제한 : 1초, 메모리 제한 : 128 MB

메모리 : 29140 KB, 시간 : 72 ms
'''

import sys
input = sys.stdin.readline


def dfs(x, y):
    global count_house

    for i in range(4):
        xx = x + dx[i]
        yy = y + dy[i]

        if 0 <= xx < N and 0 <= yy < N:
            if arr[xx][yy] != '0':  # 방문 X
                arr[xx][yy] = '0'
                count_house[count - 1] += 1

                print(xx, yy)
                dfs(xx, yy)


# 입력
N = int(input())
arr = [[y for y in input().strip()] for _ in range(N)]

# 풀이
count = 0
count_house = []

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for i in range(N):
    for j in range(N):
        if arr[i][j] == '1':  # 방문 할 수 있는 노드
            count += 1
            count_house.append(1)

            arr[i][j] = '0'
            dfs(i, j)

# 출력
print(count)
for i in sorted(count_house):
    print(i)