""" 소수 찾기

"""

from itertools import permutations


def is_prime(num):
    if num < 2:
        return False

    if num == 2:
        return True

    if num % 2 == 0:
        return False

    # 홀수만 검사
    for i in range(3, int(num ** 0.5) + 1, 2):
        if num % i == 0:
            return False

    return True


def dfs(numbers, visited, current, prime_numbers):

    if current:
        num = int(current)

        # 아직 소수 검사 안한 숫자면 소수 판별
        if is_prime(num):
            prime_numbers.add(num)


    # 최대 길이까지 만들어졌으면 stop
    if len(numbers) == len(current):
        return

    for i, num in enumerate(numbers):
        if visited[i]:
            continue

        visited[i] = True

        dfs(numbers, visited, current + num, prime_numbers)

        visited[i] = False



def solution(numbers):
    visited = [False] * len(numbers)
    prime_numbers = set() # 만들어진 소수 배열

    dfs(numbers, visited, '', prime_numbers)

    return len(prime_numbers)


def solution_2(numbers):

    n = len(numbers)
    prime_numbers = set()

    for i in range(1, n + 1):
        permutation = permutations(numbers, i)

        for num in permutation:
            int_num = int(''.join(num))

            if is_prime(int_num):
                prime_numbers.add(int_num)

    return len(prime_numbers)



print(solution("011"))
print(solution_2("011"))