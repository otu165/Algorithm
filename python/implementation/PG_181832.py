""" 정수를 나선형으로 배치하기

분류 : 구현, 시뮬레이션, 2차원 배열

전체 단계
ㄴ n x n 크기의 2차원 배열 생성
ㄴ 다음 위치(nx, ny) 가 배열 범위를 벗어나거나 이미 숫자가 저장된 칸이면 방향 전환
ㄴ 모든 숫자를 채울 때까지 반복

방향 배열(dx, dy)
ㄴ 나선형 이동은 "오른쪽 > 아래 > 왼쪽 > 위" 순서로 반복됨
ㄴ 방향 배열을 사용하면 행/열 이동을 쉽게 관리할 수 있음

입출력 예시
ㄴ n = 4
ㄴ result = [
    [1, 2, 3, 4],
    [12, 13, 14, 5],
    [11, 16, 15, 6],
    [10, 9, 8, 7]
]

"""


def solution(n):

    answer = [[0] * n for _ in range(n)]

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    x, y = 0, 0     # 좌표
    dir = 0         # 현재 방향

    for num in range(1, n * n + 1):
        answer[x][y] = num

        # 다음에 방문할 좌표
        nx = x + dx[dir]
        ny = y + dy[dir]

        # 좌표 유효성 검사
        if (
                (nx < 0) or (nx == n) or
                (ny < 0) or (ny == n) or
                (answer[nx][ny] != 0)
        ):
            # 방향 전환
            dir = (dir + 1) % 4

            nx = x + dx[dir]
            ny = y + dy[dir]

        x, y = nx, ny

    return answer


print(solution(4))



