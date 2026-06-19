""" 최대공약수와 최소공배수

분류 : 수학, 유클리드 호제법

전체 단계
ㄴ 최대공약수(GCD, Greatest Common Divisor) 구하기
ㄴ 최소공배수(LCM, Least Common Multiple) 구하기
ㄴ [GCD, LCM] 반환

시간복잡도
ㄴ 최대공약수 : O(logN)
ㄴ 최소공배수 : O(1)
ㄴ 전체 : O(logN)

입출력 예시
ㄴ n = 3, m = 12, result = [3, 12]
ㄴ n = 2, m = 5, result = [1, 10]

"""

import math

def solution(n, m):
    # 1. 최대공약수 구하기
    gcd = math.gcd(n, m)

    # 2. 최소공배수 구하기
    lcm = (n * m) // gcd

    return [gcd, lcm]


print(solution(3, 12))
