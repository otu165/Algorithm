''' 자물쇠와 열쇠

'''


def rotate(key):
    return list(zip(*key[::-1]))


def is_valid(key, world, x, y, M, N):
    for xx in range(M):
        for yy in range(M):
            world[x + xx][y + yy] += key[xx][yy]

    s = 0
    for xx in range(N):
        for yy in range(N):
            if world[M + xx][M + yy] == 1:
                s += world[M + xx][M + yy]

    if s == N * N:
        return True

    for xx in range(M):
        for yy in range(M):
            world[x + xx][y + yy] -= key[xx][yy]

    return False


def solution(key, lock):
    # 1. 자물쇠의 홈 개수 > 열쇠의 돌기 개수
    lock_home = 0
    for i in lock:
        lock_home += i.count(0)

    key_dolgi = 0
    for i in key:
        key_dolgi += i.count(1)

    if key_dolgi < lock_home:
        return False

    M, N = len(key), len(lock)

    width = 2 * M + N
    world = [[0] * width for _ in range(width)]

    for x in range(N):
        for y in range(N):
            world[x + M][y + M] = lock[x][y]

    for _ in range(4):
        key = rotate(key)

        for x in range(1, M + N):
            for y in range(1, M + N):
                if is_valid(key, world, x, y, M, N):
                    return True

    return False



print(solution([[0, 0, 0], [1, 0, 0], [0, 1, 1]], [[1, 1, 1], [1, 1, 0], [1, 0, 1]]))