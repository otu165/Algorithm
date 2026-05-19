# 1. 입력
N, K = map(int, input().split())

# 2. 풀이
s = 0
for i in range(1, K + 1):  # 1 ~ K
    s += i

flag = (N - s) // K + 1

if flag < 1:
    print(-1)
else:
    s = s + K * (flag - 1)

    print(K if N - s > 0 else K - 1)