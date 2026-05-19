''' 피보나치는 지겨웡
시간 제한 : 1초, 메모리 제한 : 512 MB

'''


def fibonacci(n):
    if n < 2:
        return n
    return fibonacci(n - 2) + fibonacci(n - 1)


# 입력
n = int(input())  # 0 <= n <= 50

# 풀이
if n < 2:
    print(1)
    exit(0)

dp = [0] * (n + 1)
dp[0], dp[1] = 1, 1

for i in range(2, n + 1):
    dp[i] = dp[i - 1] + dp[i - 2] + 1

# 출력
print(dp[n] % 1000000007)