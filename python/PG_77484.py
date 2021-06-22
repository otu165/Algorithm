''' 로또의 최고 순위와 최저 순위

45개의 숫자 중 6개를 맞힌다.
n등을 만드는 방법 n개 but 6등은 불가능함

return [최고 순위, 최저 순위]
'''


def solution(lottos, win_nums):
    # 1. 일치하는 번호 -> 최저 순위
    common = set(lottos).intersection(set(win_nums))
    lowest = len(common)

    # 2. 일치하는 번호 + 모르는 번호 -> 최고 순위
    num = lottos.count(0)
    highest = len(common) + num

    grade = [6, 6, 5, 4, 3, 2, 1]
    answer = [grade[highest], grade[lowest]]

    return answer


print(solution([44, 1, 0, 0, 31, 25], [31, 10, 45, 1, 6, 19]))
