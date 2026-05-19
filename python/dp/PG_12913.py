''' 땅따먹기

'''

def solution(land):

    for i in range(1, len(land)):
        for j in range(4):
            value = land[i][j]

            for k in range(4):
                if k == j:
                    continue

                land[i][j] = max(land[i][j], value + land[i-1][k])

    return max(land[len(land) - 1])


print(solution([[1, 2, 3, 5], [5, 6, 7, 8], [4, 3, 2, 1]]))
