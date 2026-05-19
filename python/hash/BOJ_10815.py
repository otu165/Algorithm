''' 숫자 카드
시간 : 2900ms (2초), 메모리 : 111540KB (256MB)

**주의**
카드의 숫자가 큼 (2천만 범위)
'''

import sys
sys.setrecursionlimit(10**6)
read = sys.stdin.readline


def binary_search(card):
    start = 0
    end = N - 1

    while start <= end:
        mid = (start + end) // 2

        if arr[mid] == card:
            return 1

        if arr[mid] < card:
            start = mid + 1
        else:
            end = mid - 1

    return 0


# 입력
N = int(read())
arr = list(map(int, read().split()))

M = int(read())
check = list(map(int, read().split()))

# 풀이 & 출력
arr.sort()

for card in check:
    print(binary_search(card), end=' ')
