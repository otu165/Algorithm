''' 상자넣기
시간 : 192ms (~2초), 메모리 : 29200KB (~128MB)
분류 : DP
제출 : Python3
'''

# 입력
n = int(input())
arr = list(map(int, input().rstrip().split()))

# 풀이
dp = [1] * n

for i, v in enumerate(arr):
    cnt = 0

    for j in range(i):  # 내 앞의 dp 값들과 비교
        if arr[j] < arr[i] and cnt < dp[j]:
            cnt = dp[j]

    dp[i] += cnt

# 출력
print(max(dp))
