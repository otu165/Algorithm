''' 연속 부분 수열 합의 개수

분류 : 구현, 브루트포스, 자료구조(set)

전체 단계
ㄴ 원형 수열 처리를 위해 elements 를 2번 이어붙임
ㄴ 중복 처리를 위해 set 사용
ㄴ 부분 수열 길이를 1 ~ n 까지 증가시키며 연속 부분 수열 합 계산

입출력 예시
ㄴ elements = [7, 9, 1, 1, 4], result = 18
ㄴ elements = [1, 1, 1], result = 3

'''


def solution(elements):
    answer = set()
    circle = elements * 2
    n = len(elements)

    for i in range(n):
        for j in range(1, n + 1):
            answer.add(sum(circle[i:i + j]))

    return len(answer)


print(solution([7,9,1,1,4]))