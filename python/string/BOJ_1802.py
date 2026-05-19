''' 종이접기
시간 제한 : 2초, 메모리 제한 : 128 MB

시간 : 76 ms, 메모리 : 28776 KB
'''

import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline


def solve(case):
    if len(case) <= 1:
        return True

    flag = True
    for i in range(len(case) // 2):
        if case[i] == case[-1 - i]:
            flag = False
            break

    if flag:
        return solve(case[:len(case) // 2]) and solve(case[len(case) // 2 + 1:])
    else:
        return False


# 입력
for _ in range(int(input())):
    case = list(input().strip())

    # 풀이 & 출력
    print("YES" if solve(case) else "NO")
