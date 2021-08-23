''' 합분해
시간 : 92ms (~2초), 메모리 : 30476KB (~128MB)
분류 : DP
제출 : Python3
'''

# 입력
N, K = map(int, input().split())  # 1 <= N, K <= 200

# 풀이
'''
N = 5, K = 1 ~ 3 인 경우

    0   1   2   3   4   5
1   1   1   1   1   1   1  (1개의 숫자로 N을 만드는 방법은 자기 자신뿐)
2   1   2   3   4   5   6
3   1   3   6   10  15  21

'''

dp = [[1] * (N + 1) for _ in range(K)]

for x in range(1, K):
    for y in range(1, N + 1):
        dp[x][y] = (dp[x][y-1] + dp[x-1][y]) % 1000000000

# 출력
print(dp[-1][-1])

