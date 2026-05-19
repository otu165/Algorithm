''' 이분 그래프
시간 : 1660ms (~2초), 메모리 : 62948KB (~256MB)
분류 : DFS/BFS
제출 : Python3
'''

import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline


def dfs(node, color):
    global isBipartite
    visited[node] = color

    for next in graph[node]:
        # 인접 노드와 색이 같으면 이분 그래프가 될 수 없음
        if visited[next] == color:
            isBipartite = False
            return

        if visited[next] == 0:
            dfs(next, color * -1)


for _ in range(int(input())):
    V, E = map(int, input().split())  # 정점의 개수, 간선의 개수
    graph = [[] for _ in range(V + 1)]

    for i in range(E):
        a, b = map(int, input().split())
        # 그래프
        graph[a].append(b)
        graph[b].append(a)

    # 풀이
    isBipartite = True
    visited = [0 for _ in range(V + 1)]  # 미방문 : 0 / 색깔 : 1, -1

    for node in range(1, V + 1):
        if visited[node] == 0:
            dfs(node, 1)

            if not isBipartite:
                break

    # 출력
    print("YES" if isBipartite else "NO")
