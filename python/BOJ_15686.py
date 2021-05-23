''' 치킨 배달
시간 : 824ms (1초), 메모리 : 29200KB (512MB)
분류 : 구현, 브루트포스

'''

import sys
from itertools import combinations
read = sys.stdin.readline


def get_distance(r1, c1, r2, c2):
    return abs(r1-r2) + abs(c1-c2)


# 입력
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

# 풀이
# 1. 치킨, 집 리스트 구하기
chicken, house = [], []

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            house.append((i, j))

        if arr[i][j] == 2:
            chicken.append((i, j))

# 2. 각 집의 치킨 거리 구하기
answer = sys.maxsize
for case in combinations(chicken, M):
    distance = 0

    for h in house:
        d = 101
        for c in case:
            d = min(d, get_distance(c[0], c[1], h[0], h[1]))

        distance += d

    answer = min(answer, distance)

# 출력
print(answer)