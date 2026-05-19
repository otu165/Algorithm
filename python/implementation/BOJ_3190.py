''' 뱀
시간 : 112ms (~1초), 메모리 : 31780KB (~128MB)
분류 : 구현
제출 : Python3
'''

from collections import deque
import sys
input = sys.stdin.readline


def turn(c):
    global dir

    if dir == 'L':
        dir = 'D' if c == 'L' else 'U'
    elif dir == 'R':
        dir = 'U' if c == 'L' else 'D'
    elif dir == 'U':
        dir = 'L' if c == 'L' else 'R'
    elif dir == 'D':
        dir = 'R' if c == 'L' else 'L'


# 입력
N = int(input())  # 보드 크기
K = int(input())  # 사과 개수
apple = [tuple(map(int, input().split())) for _ in range(K)]
L = int(input())  # 뱀의 방향 전환 횟수(X초가 끝난 뒤 L(왼), D(오) 로 90도 회전함)
snake = [list(input().split()) for _ in range(L)]

# 풀이
route = deque()  # TAIL ~ HEAD
route.append((1, 1))  # x, y
dir = 'R'

size = 0
while True:
    x, y = route[-1]

    # 1. 몸 길이 늘리기  # 현재 머리 위치 : (nx, ny)
    size += 1
    if dir == 'L':
        nx, ny = x, y - 1
    elif dir == 'R':
        nx, ny = x, y + 1
    elif dir == 'U':
        nx, ny = x - 1, y
    else:
        nx, ny = x + 1, y

    # 2. 종료 조건
    if (nx, ny) in route or not (1 <= nx <= N and 1 <= ny <= N):
        # 출력
        print(size)
        break

    route.append((nx, ny))

    # 3. 사과 유무
    if (nx, ny) in apple:
        apple.remove((nx, ny))
    else:
        route.popleft()

    # 4. 방향 전환
    if len(snake) != 0 and int(snake[0][0]) == size:
        turn(snake[0][1])
        del snake[0]
