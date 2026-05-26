""" 같은 숫자는 싫어

분류 : 스택(list), 구현

전체 단계
ㄴ stack 이 비어있으면 숫자 추가
ㄴ stack 이 비어있지 않고, 이전값과 다른 숫자면 숫자 추가

시간복잡도
ㄴ 배열 순회 : O(1)
ㄴ append(), top 조회 : O(1)
ㄴ 전체 : O(n)

입출력 예시
ㄴ arr = [1,1,3,3,0,1,1]
ㄴ result = [1, 3, 0, 1]

"""


def solution(arr):
    stack = []

    for num in arr:
        if not stack or stack[-1] != num:
                stack.append(num)

    return stack


print(solution([1,1,3,3,0,1,1]))