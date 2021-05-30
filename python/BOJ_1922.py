''' 네트워크 연결
시간 : 360ms (2초), 메모리 : 52024KB (256MB)
분류 : 최소 신장 트리 (using Kruskal algorithm)
'''

import sys
read = sys.stdin.readline


def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]


def union(a, b):
    a = find(a)
    b = find(b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b


# 입력
N = int(read())  # 컴퓨터 수
M = int(read())  # 연결할 수 있는 선의 수
arr = [list(map(int, read().split())) for _ in range(M)]  # a->b 연결비용 c

# 풀이
arr.sort(key=lambda x: x[2])
parent = [x for x in range(N + 1)]

answer = 0
for a, b, cost in arr:
    if find(a) != find(b):  # 서로소 집합인 경우
        union(a, b)
        answer += cost

# 출력
print(answer)

