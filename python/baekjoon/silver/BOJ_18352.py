import sys
from collections import deque


def bfs():
    global result

    distance = [-1] * (N + 1)  # 최단 거리
    distance[X] = 0

    queue = deque([X])

    while queue:
        city = queue.popleft()

        if distance[city] == K:
            result.append(city)
            continue

        for next_city in street[city]:
            if distance[next_city] == -1:
                distance[next_city] = distance[city] + 1
                queue.append(next_city)


# 입력
input = sys.stdin.readline
N, M, K, X = map(int, input().split())

street = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B = map(int, input().split())
    street[A].append(B)  # A -> B 단방향 도로


# 풀이
result = []  # 목적지
bfs()

# 출력
if len(result) == 0:
    print(-1)
else:
    result.sort()

    for i in result:
        print(i)
