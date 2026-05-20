""" 폰켓몬

분류 : 해시

전체 단계
ㄴ 최대 선택 가능 개수 = len(nums) // 2
ㄴ 종류 수(len(set(nums)))가 더 적다면, 그만큼만 선택 가능

시간복잡도
ㄴ set 생성 : O(n)
ㄴ len(), min() : O(1)
ㄴ 전체 : O(n)

입출력 예시
ㄴ nums = [3, 1, 2, 3], result = 2
ㄴ nums = [3,3,3,2,2,4], result = 2

"""


def solution(nums):

    return min(len(nums) // 2, len(set(nums)))


print(solution([3,3,3,2,2,2]))