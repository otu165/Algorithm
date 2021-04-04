from itertools import combinations

N, M = map(int, input().split())  # 1 <= M <= N <= 8

n_list = [x for x in range(1, N + 1)]
result = list(combinations(n_list, M))

for i in result:
    print(*i)
