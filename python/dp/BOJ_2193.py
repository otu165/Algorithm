''' 이친수
시간 : 92ms (~2초), 메모리 : 29200KB (~128MB)
분류 : DP
제출 : Python3
'''

# 입력
N = int(input())

# 풀이
'''
N = 1, Answer = 1
N = 2, Answer = 1
N = 3, Answer = 2 (F(1) + F(2))
N = 4, Answer = 3 (F(2) + F(3))
N = 5, Answer = 5 (F(3) + F(4))
'''

if N < 3:
    print(1)
else:
    dp = [0] * (N + 1)
    dp[1], dp[2] = 1, 1

    for i in range(3, N + 1):
        dp[i] = dp[i - 1] + dp[i - 2]

    print(dp[N])


