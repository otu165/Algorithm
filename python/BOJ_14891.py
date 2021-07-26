''' 톱니바퀴
시간 : 72ms (~2초), 메모리 : 29200KB (~512MB)
분류 : 구현, 시뮬레이션
제출 : Python3
'''

import sys
input = sys.stdin.readline


def rotate(n, d):
    if n == 1:
        need_to_rotate = rotate_first(d)
    elif n == 2:
        need_to_rotate = rotate_second(d)
    elif n == 3:
        need_to_rotate = rotate_third(d)
    elif n == 4:
        need_to_rotate = rotate_fourth(d)

    for nn, dd in need_to_rotate:
        if dd == 1:
            rotate_right(nn)
        else:
            rotate_left(nn)


def rotate_first(d):  # 왼쪽 인덱스 : 6 / 오른쪽 인덱스 : 2
    need_to_rotate = [(0, d)]

    if arr[0][2] != arr[1][6]:
        d = 1 if d == -1 else -1
        need_to_rotate.append((1, d))

        if arr[1][2] != arr[2][6]:
            d = 1 if d == -1 else -1
            need_to_rotate.append((2, d))

            if arr[2][2] != arr[3][6]:
                d = 1 if d == -1 else -1
                need_to_rotate.append((3, d))

    return need_to_rotate


def rotate_second(d):
    need_to_rotate = [(1, d)]

    if arr[0][2] != arr[1][6]:
        need_to_rotate.append((0, 1 if d == -1 else -1))

    if arr[1][2] != arr[2][6]:
        d = 1 if d == -1 else -1
        need_to_rotate.append((2, d))

        if arr[2][2] != arr[3][6]:
            d = 1 if d == -1 else -1
            need_to_rotate.append((3, d))

    return need_to_rotate


def rotate_third(d):
    need_to_rotate = [(2, d)]

    if arr[2][2] != arr[3][6]:
        need_to_rotate.append((3, 1 if d == -1 else -1))

    if arr[1][2] != arr[2][6]:
        d = 1 if d == -1 else -1
        need_to_rotate.append((1, d))

        if arr[0][2] != arr[1][6]:
            d = 1 if d == -1 else -1
            need_to_rotate.append((0, d))

    return need_to_rotate


def rotate_fourth(d):
    need_to_rotate = [(3, d)]

    if arr[2][2] != arr[3][6]:
        d = 1 if d == -1 else -1
        need_to_rotate.append((2, d))

        if arr[1][2] != arr[2][6]:
            d = 1 if d == -1 else -1
            need_to_rotate.append((1, d))

            if arr[0][2] != arr[1][6]:
                d = 1 if d == -1 else -1
                need_to_rotate.append((0, d))

    return need_to_rotate


def rotate_right(n):  # 시계방향
    global arr
    arr[n] = [arr[n][7], arr[n][0], arr[n][1], arr[n][2], arr[n][3], arr[n][4], arr[n][5], arr[n][6]]


def rotate_left(n):  # 반시계 방향
    global arr
    arr[n] = [arr[n][1], arr[n][2], arr[n][3], arr[n][4], arr[n][5], arr[n][6], arr[n][7], arr[n][0]]


# 입력
arr = [list(map(int, list(input().rstrip()))) for _ in range(4)]  # N극 : 0, S극 : 1
K = int(input())  # 회전 횟수

# 풀이
for i in range(K):
    n, d = map(int, input().split())  # 회전시킬 톱니바퀴 번호, 방향(1 : 시계, -1 : 반시계)
    rotate(n, d)

# 출력
col = list(zip(*arr))[0]
print(1 * col[0] + 2 * col[1] + 4 * col[2] + 8 * col[3])