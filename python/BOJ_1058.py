''' 친구
시간 제한 : 2초, 메모리 제한 : 128 MB

시간 : 96 ms, 메모리 : 28776 KB
'''


# 입력
N = int(input())  # 1 <= N <= 50
arr = [list(input()) for _ in range(N)]

# 풀이
# 1. 인접리스트 생성
graph = []
for i in range(N):
    graph.append([])

    friend = [idx for idx, x in enumerate(arr[i]) if x != 'N' and idx != i]
    graph[i].extend(friend)

# 2. 그래프 탐색
most_famous = 0
for i in range(N):
    my_famous = graph[i].copy()  # 나의 친구는 전부 2-친구

    for j in graph[i]:  # 친구 C 존재
        for k in graph[j]:
            if i == k:  # 자기자신 제외
                continue

            if k not in graph[i] and k not in my_famous:
                my_famous.append(k)

    most_famous = max(most_famous, len(my_famous))

# 출력
print(most_famous)