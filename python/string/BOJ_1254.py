''' 팰린드롬 만들기
시간 : 84ms (~2초), 메모리 :  29200KB (~128MB)
분류 : 브루트포스
제출 : Python3
'''

# 입력
S = input().rstrip()

# 풀이
answer = len(S)
cnt = 0

while True:
    start = S[cnt:]
    end = start[::-1]

    if start == end:
        answer += cnt
        break

    cnt += 1

# 출력
print(answer)



