# 가장 먼 노드

from collections import deque


def bfs(graph, n):
    q = deque()
    q.append((1, 0))  # 시작노드, 거리

    visited = [-1 for x in range(n + 1)]
    visited[1] = 0

    while q:
        x, d = q.popleft()

        for i in graph[x]:
            if visited[i] == -1:
                visited[i] = d + 1
                q.append((i, d + 1))

    max_val = max(visited)
    return visited.count(max_val)


def solution(n, edge):
    # 1. 인접그래프 만들기
    graph = [[] for _ in range(n + 1)]
    for s, e in edge:
        graph[s].append(e)
        graph[e].append(s)

    for e in graph:
        e.sort()

    # 2. 거리 구하기
    return bfs(graph, n)