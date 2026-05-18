""" 의상

분류 : 해쉬(Hash), 딕셔너리, 조합

전체 단계
ㄴ 옷 종류별로 나누기
ㄴ 각 종류마다 "입는 경우 + 안 입는 경우" 계산 (종류별 옷 개수 + 1)
ㄴ 모든 종류의 경우의 수 곱하기
ㄴ 아무것도 안 입는 경우 제외

왜 모든 종류를 곱할까?
ㄴ 각 선택은 서로 독립적이기 때문

입출력 예시
ㄴ clothes =
[
    ["yellow_hat", "headgear"],
    ["blue_sunglasses", "eyewear"],
    ["green_turban", "headgear"]
]
ㄴ result = 5

"""


def solution(clothes):

    # 옷 종류별로 나누기
    arr = {}

    for value, key in clothes:
        arr[key] = arr.get(key, 0) + 1

    # 경우의 수 구하기
    answer = 1

    for value in arr.values():
        answer *= value + 1

    # return 가능한 모든 경우의 수
    return answer - 1


clothes = [
    ["yellow_hat", "headgear"],
    ["blue_sunglasses", "eyewear"],
    ["green_turban", "headgear"]
]

print(solution(clothes))