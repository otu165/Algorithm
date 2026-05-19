''' 숫자의 개수
시간 제한 : 1초, 메모리 제한 : 128 MB

시간 : 68 ms, 메모리 : 28776 KB
'''

# 입력
A = int(input())
B = int(input())
C = int(input())

# 풀이
result = str(A * B * C)

# 출력
for i in range(10):
    print(result.count(str(i)))

