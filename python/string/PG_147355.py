""" 크기가 작은 부분 문자열

분류 : 문자열, 구현

전체 단계
ㄴ p 길이만큼 부분 문자열 추출
ㄴ 부분문자열이 p 이하이면 정답 개수 증가

입출력 예시
ㄴ t = "3141592", p = "271", result = 2
ㄴ t = "500220839878", p = "7", result = 8

"""


def solution(t, p):

    l = len(p)
    answer = 0

    for i in range(0, len(t) - l + 1):

        part = t[i:i+l] # 부분문자열

        if int(part) <= int(p):
            answer += 1

    return answer


print(solution("500220839878", "7"))