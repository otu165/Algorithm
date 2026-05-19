''' 올바른 괄호

올바른 괄호 : return True
올바르지 않은 괄호 : return False

'''


def solution(s):

    # 1.
    if s.count("(") != s.count(")"):
        return False

    left, right = 0, 0
    for i in s:
        if i == '(':
            left += 1
        else:
            right += 1

        # 2.
        if left < right:
            return False

    # 3.
    if left != right:
        return False

    return True


print(solution("(()("))