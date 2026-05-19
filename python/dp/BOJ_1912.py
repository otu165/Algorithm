''' 연속합
시간 제한 : 1초, 메모리 제한 : 128 MB

시간 : 124 ms, 메모리 : 36992 KB
'''

# 입력
n = int(input())  # 1 <= n <= 100,000
arr = list(map(int, input().split()))

# 풀이
if max(arr) <= 0:  # 음수로만 이루어진 수열
    print(max(arr))
elif min(arr) >= 0:  # 양수로만 이루어진 수열
    print(sum(arr))
else:  # 양수, 음수가 섞인 수열
    dp = [0] * n
    dp[0] = arr[0]

    for i in range(1, n):
        dp[i] = max(arr[i], dp[i-1] + arr[i])

    # 출력
    print(max(dp))
