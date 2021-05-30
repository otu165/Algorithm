''' 최소비용 구하기
시간 : 220ms (0.5초), 메모리 : 42668KB (128MB)
분류 : 다익스트라
'''

import sys
from heapq import heappush, heappop

read = sys.stdin.readline
INF = sys.maxsize


def dijkstra(start):
    q = []
    heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heappop(q)

        # 현재 노드가 이미 처리된 적 있는 노드라면 무시
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드들을 확인
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heappush(q, (cost, i[0]))

        if now == destination:
            return


# 입력
N = int(read())  # 도시의 개수
M = int(read())  # 버스의 개수
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    a, b, c = map(int, read().split())  # 버스의 정보(출발지, 도착지, 버스비)
    graph[a].append((b, c))
start, destination = map(int, read().split())  # 출발지, 도착지

# 풀이
distance = [INF] * (N + 1)
dijkstra(start)

# 출력
print(distance[destination])
