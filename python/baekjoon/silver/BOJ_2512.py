import sys


def solve():

    limit = M // N  # 상한액

    before, now = True, False

    while True:
        s = 0

        for i in arr:
            if i < limit:
                s += i
            else:
                s += limit

        # 예산 만족?
        now = True if s <= M else False

        # 조건 만족?
        if before and not now:
            return limit - 1
        else:
            limit += 1


# 입력
N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())

# 풀이
if sum(arr) <= M:
    # 출력_Case 1
    print(max(arr))
else:
    # 출력_Case 2
    print(solve())

