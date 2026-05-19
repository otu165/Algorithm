''' 괄호 제거
시간 : 472ms (~1초), 메모리 : 29452KB (~128MB)
분류 : 문자열
제출 : Python3
'''

from itertools import combinations


def can(arr):
    num = [0 for _ in range(11)]

    for i in arr:
        num[i[1]] += 1

    for i in num:
        if i % 2 == 1:
            return False

    return True


# 입력
exp = input().rstrip()

# 풀이
# 1. (, ) 구분하기
open, close = [], []

stack = []
cnt = 0
for idx, value in enumerate(exp):
    if value == '(':
        stack.append((idx, value))
    elif value == ')':
        cnt += 1
        close.append((idx, cnt))
        i, v = stack.pop()
        open.append((i, cnt))

# 2. # ( 에서 N개, ) 에서 N개 픽하기
answer = []

for limit in range(1, len(open) + 1):
    open_comb = list(combinations(open, limit))
    close_comb = list(combinations(close, limit))

    for i in open_comb:
        for j in close_comb:
            total = i + j

            if not can(total):
                continue

            remove = []

            for t in total:
                remove.append(t[0])

            tmp = ''
            for idx, value in enumerate(exp):
                if idx in remove:
                    continue
                tmp += value

            if tmp not in answer:
                answer.append(tmp)

# 출력
print(*sorted(answer), sep='\n')
