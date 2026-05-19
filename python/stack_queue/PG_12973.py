''' 짝지어 제거하기

전체 단계
ㄴ 빈 스택 생성
ㄴ 문자열을 왼쪽부터 탐색
ㄴ 직전 문자와 같으면 제거(pop) / 다르면 추가(append)
ㄴ 마지막에 스택이 비었는지 확인

왜 스택을 사용하는가?
ㄴ 문제의 핵심은 "바로 붙어 있는 같은 문자" 를 제거하는 것
ㄴ 스택을 사용하면 가장 최근 문자를 빠르게 확인할 수 있다.

입출력 예시
ㄴ s = "baabaa", result = 1
ㄴ s = "cdcd", result = 0

'''

def solution(s):
    stack = []

    for i in range(len(s)):

        if stack and stack[-1] == s[i]:
            stack.pop()
        else:
            stack.append(s[i])

    return int(not stack)
