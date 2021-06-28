''' 주사위 굴리기
시간 : 76ms (~2초), 메모리 : 29200KB (~512MB)
분류 : 구현
제출 : Python3
'''

import sys

input = sys.stdin.readline


def roll_the_dice(m):
    if m == 1:  # 동
        return [dice[0], dice[2], dice[3], dice[5], dice[4], dice[1]]
    if m == 2:  # 서
        return [dice[0], dice[5], dice[1], dice[2], dice[4], dice[3]]
    if m == 3:  # 남
        return [dice[2], dice[1], dice[4], dice[3], dice[5], dice[0]]
    if m == 4:  # 북
        return [dice[5], dice[1], dice[0], dice[3], dice[2], dice[4]]


# 입력
N, M, x, y, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
move = list(map(int, input().split()))

# 풀이
dice = [0, 0, 0, 0, 0, 0]
dir = [(0, 0), (0, 1), (0, -1), (-1, 0), (1, 0)]

btm_idx, top_idx = 2, 5
for m in move:
    dx, dy = dir[m]

    if 0 <= x + dx <= N - 1 and 0 <= y + dy <= M - 1:
        x = x + dx
        y = y + dy

        dice = roll_the_dice(m)

        if arr[x][y] != 0:  # 1. 칸에 쓰인 수 주사위 바닥면으로 복사, 칸에 쓰인 수 = 0
            dice[btm_idx] = arr[x][y]
            arr[x][y] = 0
        else:  # 2. 주사위 바닥면의 수 칸에 복사
            arr[x][y] = dice[btm_idx]

        # 출력
        print(dice[top_idx])
