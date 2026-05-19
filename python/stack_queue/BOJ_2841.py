''' 외계인의 기타 연주
시간 : 948ms (~1초), 메모리 : 29200KB (~256MB)
분류 : 스택
제출 : Python3
'''

import sys
input = sys.stdin.readline


# 입력
N, P = map(int, input().split())  # 음의 수, 프렛의 수

# 풀이
answer = 0
pressed = [[] for i in range(7)]

for i in range(N):
    ln, pn = map(int, input().split())  # 줄의 번호, 프렛의 번호

    try:
        bpn = pressed[ln][-1]
    except IndexError:
        bpn = 0

    if bpn < pn:  # 더 큰 프렛을 누르는 경우
        pressed[ln].append(pn)
        answer += 1
    else:  # 더 작은 프렛을 누르는 경우
        while True:
            try:
                bpn = pressed[ln][-1]
                if pn < bpn:
                    pressed[ln].pop()
                    answer += 1
                else:
                    break
            except IndexError:
                break

        if len(pressed[ln]) != 0 and pressed[ln][-1] == pn:
            continue
        else:
            pressed[ln].append(pn)
            answer += 1

# 출력
print(answer)
