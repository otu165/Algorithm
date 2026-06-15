""" 타켓 넘버

풀이 방법
ㄴ 1. 중복 순열
ㄴ 2. DFS
(이 문제에서는 두 풀이 모두 완전 탐색이다)

중복 순열
ㄴ 생성된 모든 부호 조합을 순회하여 결과 계산
ㄴ 길이가 N일 때 경우의 수 = 2^N
ㄴ 문제 조건상 N = 20 이 최대이므로, 2^20 = 1,048,576개 조합 생성됨
ㄴ 시간복잡도 : O(2^N)

DFS
ㄴ +, - 두 갈래로 분기하며 모든 경우 탐색
ㄴ DFS 전체 호출 수 = 1 + 2 + 4 + ... + 2^N (등비수열 합 = 2^(N+1) - 1)
ㄴ 문제 조건상 N = 20 이 최대이므로, 2^21 - 1 = 2,097,151번 함수 호출됨
ㄴ 시간복잡도 : O(2^N)

입출력 예시
ㄴ numbers = [1, 1, 1, 1, 1], taret = 3, result = 5

"""

from itertools import product


def solution(numbers, target):
    # 중복순열 풀이
    signs = product(['-', '+'], repeat=len(numbers))

    result = 0

    for s in signs:
        cal = 0

        for i, num in enumerate(numbers):
            if s[i] == '+':
                cal += num
            else:
                cal -= num

        if cal == target:
            result += 1

    return result


def dfs(numbers, target, depth, cal):
    # DFS 풀이

    if depth == len(numbers):
        if target == cal:
            return 1
        else:
            return 0

    return (
        dfs(numbers, target, depth + 1, cal + numbers[depth]) # + 부호 커버
        +
        dfs(numbers, target, depth + 1, cal - numbers[depth]) # - 부호 커버
    )


numbers = [4, 1, 2, 1]
target = 4

print(solution(numbers, target))
print(dfs(numbers, target, 0, 0))

