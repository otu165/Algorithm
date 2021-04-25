''' ATM
시간 제한 : 1초, 메모리 제한 : 256 MB

시간 제한 : 68 ms, 메모리 제한 : 28776 KB
'''

# 입력
N = int(input())
time = list(map(int, input().split()))

# 풀이
time.sort()

for i in range(1, N):
    time[i] += time[i-1]

# 출력
print(sum(time))
