""" 올바른 괄호

분류 : 스택, 구현

전체 단계
ㄴ 여는 괄호 "(" 가 나오면 스택에 추가
ㄴ 닫는 괄호 ")" 가 나오면 스택에서 "(" 제거
    ㄴ 스택이 비어있는데 닫는 괄호가 나오면 "(" 제거 불가능하니 return False
ㄴ 순회 종료 후 스택이 비어있으면 True

시간복잡도
ㄴ 문자열 순회 : O(n)
ㄴ append(), pop() : O(1)
ㄴ 전체 : O(n)

입출력 예시
ㄴ s = "()()" / result = True
ㄴ s = "(()))(" / result = False

"""


def solution(s):
    stack = []

    for char in s:
        if char == "(":
            stack.append(char)
        else:
            if not stack: # 스택이 비어있으면
                return False

            stack.pop()

    return not stack



print(solution("(()))("))