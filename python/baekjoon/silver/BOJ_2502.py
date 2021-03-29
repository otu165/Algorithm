import sys

# 입력
input = sys.stdin.readline
D, K = map(int, input().split())

# 풀이
result = [-1, 'A', 'B']
for i in range(3, D + 1):
    result.append(result[i-1] + result[i-2])

A = 1
n_A, n_B = result[D].count('A'), result[D].count('B')

while True:
    if (K - A * n_A) % n_B == 0:
        # 출력
        print("{}\n{}".format(A, (K - A * n_A) // n_B))
        break

    A += 1


