''' 소수 만들기 '''

import math
from itertools import combinations


def is_prime(n):
    # 2부터 n의 제곱근까지의 모든 수 확인
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False

    return True


def solution(nums):
    answer = 0

    able = combinations(nums, 3)
    for i in able:
        if is_prime(sum(i)):
            answer += 1

    return answer


print(solution([1, 2, 7, 6, 4]))
