""" 모음 사전

풀이 방법
ㄴ 1. 중복 순열
ㄴ 2. DFS

중복 순열
ㄴ 길이 1 ~ 5까지의 모든 단어 생성
ㄴ word 의 위치(index) 반환
ㄴ 항상 5¹ + 5² + 5³ + 5⁴ + 5⁵ = 3905 개 만듦

DFS
ㄴ 현재 단어가 word 이면 True 를 반환하여 모든 재귀를 종료
ㄴ 최악의 경우 모든 단어(3905개)를 탐색

입출력 예시
ㄴ word : "AAAAE", result = 6
ㄴ word : "I" , result = 1563

"""

from itertools import product


def solution(word):
    # 중복 순열 풀이

    d = []
    alphabet = ['A', 'E', 'I', 'O', 'U']

    for i in range(1, 6):
        pp = product(alphabet, repeat = i)

        for p in pp:
            d.append(''.join(p))

    d.sort()

    return d.index(word) + 1


def dfs(alphabet, word, current, count):

    if current:
        count[0] += 1

    # 내가 찾던 문자열이면 재귀 종료
    if current == word:
        return True

    # 길이가 5인지 체크
    if len(current) == 5:
        return False

    for a in alphabet:
        # 정답을 찾으면 더 탐색하지 않고 바로 종료
        if dfs(alphabet, word, current + a, count):
            return True

    return False


def solution_2(word):
    alphabet = ['A', 'E', 'I', 'O', 'U']
    count = [0]

    dfs(alphabet, word, '', count)

    return count[0]


print(solution("I"))
print(solution_2("I"))