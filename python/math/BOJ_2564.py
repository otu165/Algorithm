''' 경비원
시간 제한 : 1초, 메모리 제한 : 128 MB

시간 : 68 ms, 메모리 : 28776 KB
'''

import sys
read = sys.stdin.readline

# 입력
w, h = map(int, read().split())
n = int(read())
store = [list(map(int, read().split())) for _ in range(n)]
direction, loc = list(map(int, read().split()))

# 풀이
answer = 0

if direction == 1:  # 북
    for d, l in store:
        if d == 1:
            answer += abs(loc - l)
        elif d == 2:
            left_way = loc + h + l
            right_way = (w - loc) + h + (w - l)
            answer += min(left_way, right_way)
        elif d == 3:
            answer += loc + l
        elif d == 4:
            answer += (w - loc) + l
elif direction == 2:  # 남
    for d, l in store:
        if d == 1:
            left_way = loc + h + l
            right_way = (w - loc) + h + (w - l)
            answer += min(left_way, right_way)
        elif d == 2:
            answer += abs(loc - l)
        elif d == 3:
            answer += loc + (h - l)
        elif d == 4:
            answer += (w - loc) + (h - l)
elif direction == 3:  # 서
    for d, l in store:
        if d == 1:
            answer += loc + l
        elif d == 2:
            answer += (h - loc) + l
        elif d == 3:
            answer += abs(loc - l)
        elif d == 4:
            left_way = loc + w + l
            right_way = (h - loc) + w + (h - l)
            answer += min(left_way, right_way)
elif direction == 4:  # 동
    for d, l in store:
        if d == 1:
            answer += loc + (w - l)
        elif d == 2:
            answer += (h - loc) + (w - l)
        elif d == 3:
            left_way = (h - loc) + w + (h - l)
            right_way = loc + w + l
            answer += min(left_way, right_way)
        elif d == 4:
            answer += abs(loc - l)

# 출력
print(answer)