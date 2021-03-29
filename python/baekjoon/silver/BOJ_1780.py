import sys

sys.setrecursionlimit(10 ** 8)


def solve(array, size):
    if check(array):
        return
    else:
        n = size // 3

        # 1.
        temp = []
        for i in range(n):
            temp.append(array[i][:n])
        solve(temp, n)

        # 2.
        temp.clear()
        for i in range(n):
            temp.append(array[i][n:n * 2])
        solve(temp, n)

        # 3.
        temp.clear()
        for i in range(n):
            temp.append(array[i][n * 2:])
        solve(temp, n)

        # 4.
        temp.clear()
        for i in range(n, n * 2):
            temp.append(array[i][:n])
        solve(temp, n)

        # 5.
        temp.clear()
        for i in range(n, n * 2):
            temp.append(array[i][n:n * 2])
        solve(temp, n)

        # 6.
        temp.clear()
        for i in range(n, n * 2):
            temp.append(array[i][n * 2:])
        solve(temp, n)

        # 7.
        temp.clear()
        for i in range(n * 2, size):
            temp.append(array[i][:n])
        solve(temp, n)

        # 8.
        temp.clear()
        for i in range(n * 2, size):
            temp.append(array[i][n:n * 2])
        solve(temp, n)

        # 9.
        temp.clear()
        for i in range(n * 2, size):
            temp.append(array[i][n * 2:])
        solve(temp, n)


def check(array):  # 같은 수로 이루어진 종이인가?
    global n_negative, n_zero, n_positive
    temp = []

    for i in array:
        for j in i:
            if len(temp) == 1 and j not in temp:
                return False

            if j not in temp:
                temp.append(j)

    if temp[0] == -1:
        n_negative += 1
    elif temp[0] == 0:
        n_zero += 1
    else:
        n_positive += 1

    return True


# 입력
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for i in range(N)]

# 풀이
n_negative, n_zero, n_positive = 0, 0, 0
solve(arr, N)

# 출력
print("{}\n{}\n{}".format(n_negative, n_zero, n_positive))
