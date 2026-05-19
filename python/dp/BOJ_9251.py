''' LCS_최장 공통 부분 수열
시간 : 736ms(1초), 메모리 : 37056KB(256MB)
분류 : dp

'''

# 입력
A = input().strip()
B = input().strip()

# 풀이
dp = [[0 for _ in range(len(B))] for _ in range(len(A))]

# 1. 초기값
for i, v in enumerate(A):
    dp[i][0] = min(1, dp[i-1][0] + 1) if v == B[0] else dp[i-1][0]

for i, v in enumerate(B):
    dp[0][i] = min(1, dp[0][i-1] + 1) if v == A[0] else dp[0][i-1]

# 2. dp
for j, bv in enumerate(B):  # 열
    if j == 0:
        continue

    for i, av in enumerate(A):  # 행
        if i == 0:
            continue

        if av == bv:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

# 출력
print(dp[-1][-1])






