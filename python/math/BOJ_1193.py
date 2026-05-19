''' 분수찾기
시간 제한 : 0.5초, 메모리 제한 : 256 MB

시간 : 64 ms, 메모리 : 28776 KB
'''


# 입력
X = int(input())

# 풀이
line = 1  # 몇 번째 반복인지
while True:
    if X <= line:
        break

    X -= line
    line += 1

# 출력
if line % 2 == 0:  # 짝수번째 행
    print(f'{X}/{line - X + 1}')
else:  # 홀수번째 행
    print(f'{line - X + 1}/{X}')
