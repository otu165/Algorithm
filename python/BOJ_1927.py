''' 최소 힙
시간 : 280ms (~1초), 메모리 : 35908KB (~128MB)
분류 : 최소 힙
제출 : Python3
'''

import heapq, sys
input = sys.stdin.readline

# 입력
N = int(input())
arr = [int(input()) for _ in range(N)]

# 풀이
heap = []

for num in arr:
    if num == 0:
        try:
            print(heapq.heappop(heap))
        except IndexError:
            print(0)
    else:
        heapq.heappush(heap, num)
