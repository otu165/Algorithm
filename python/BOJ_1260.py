''' DFS 와 BFS
시간 제한 : 2초, 메모리 제한 : 128 MB

메모리 : 33116 KB, 시간 : 108 ms
'''

import sys
from collections import deque
input = sys.stdin.readline


# 함수
def dfs(start):
    visited[start] = 1
    print(start, end=' ')

    for node in graph[start]:
        if not visited[node]:
            dfs(node)


def bfs(start):
    q = deque()
    q.append(start)

    visited = [0] * (N + 1)
    visited[start] = 1

    while q:
        node = q.popleft()
        print(node, end=' ')

        for i in graph[node]:
            if not visited[i]:
                visited[i] = 1
                q.append(i)


# 입력
N, M, V = map(int, input().split())  # 정점, 간선, 번호

graph = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B = map(int, input().split())

    graph[A].append(B)
    graph[B].append(A)

    graph[A].sort()
    graph[B].sort()

# 풀이
visited = [0] * (N + 1)
dfs(V)
print()

bfs(V)






