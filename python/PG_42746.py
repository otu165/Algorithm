# 가장 큰 수

from functools import cmp_to_key


def comparator(s1, s2):  # 1
    a = s1 + s2
    b = s2 + s1

    if a == b:
        return 0
    if a > b:
        return 1
    if a < b:
        return -1


def solution(numbers):
    numbers = list(map(str, numbers))
    numbers.sort(key=cmp_to_key(comparator), reverse=True)
    return str(int(''.join(numbers)))  # 2
