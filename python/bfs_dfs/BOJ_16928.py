import sys
from collections import deque
input = sys.stdin.readline


def bfs():

    q = deque()
    q.append(1)

    while q:
        x = q.popleft()

        if x == 100:
            return

        for i in range(1, 7):  # 주사위
            xx = x + i

            if xx <= 100:
                xx = arr[xx]

                if count[xx] == -1:
                    q.append(xx)
                    count[xx] = count[x] + 1


# 입력
N, M = map(int, input().split())

arr = [i for i in range(101)]

for _ in range(N + M):
    x, y = map(int, input().split())
    arr[x] = y  # x -> y로 이동

'''
1, 100 != 뱀 or 사다리
뱀과 사다리가 동시에 위치하는 칸은 없다.
항상 100번 칸에 도착할 수 있는 입력만 주어진다.
'''

# 풀이
count = [-1] * 101  # visited + counting
count[1] = 0

bfs()

# 출력 (주사위를 굴려야 하는 횟수의 최솟값)
print(count[100])