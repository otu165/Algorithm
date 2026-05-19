''' A와 B
시간 제한 : 2초, 메모리 제한 : 512 MB

시간 : 72ms, 메모리 : 29200 KB
'''

# 입력
S = input().strip()
T = input().strip()

# 풀이
while True:
    if len(T) <= len(S):
        break

    if T[-1] == 'A':
        T = T[:-1]
    else:
        T = T[:-1][::-1]

# 출력
print(1 if S == T else 0)



