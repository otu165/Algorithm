''' 0 만들기
시간 : 200ms (~1초), 메모리 : 30220KB (~128MB)
분류 : 브루트포스
제출 : Python3
'''

from itertools import product


for i in range(int(input())):
    N = int(input())
    nums = [x for x in range(1, N + 1)]

    answer = []
    arr = list(product(['+', '-', ' '], repeat=N-1))
    for j in arr:
        exp = '1'
        for idx, op in enumerate(j):
            exp += op + str(idx + 2)

        if eval(''.join(exp.split(' '))) == 0:  # eval 함수 위험
            answer.append(exp)

    print(*sorted(answer), sep='\n')
    print()


