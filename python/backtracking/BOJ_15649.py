from itertools import permutations

N, M = map(int, input().split())  # 1 <= M <= N <= 8

n_list = [x for x in range(1, N + 1)]
result = list(permutations(n_list, M))

for i in result:
    print(*i)
