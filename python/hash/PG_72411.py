''' 메뉴 리뉴얼

이전에 각 손님들이 주문할 때
가장 많이 함께 주문한 단품메뉴를 코스요리의 메뉴로 구성하기로 함

코스요리 메뉴 조건)
1. 최소 2가지 이상의 단품 메뉴로 구성
2. 최소 2명 이상의 손님으로부터 주문된 단품 메뉴 조합일 것

'''

from itertools import combinations
from collections import Counter  # 각 원소의 중복 개수를 세어준다.


def solution(orders, course):
    answer = []

    for num in course:
        comb_list = []
        for order in orders:
            comb = combinations(sorted(order), num)
            comb_list.extend(comb)

        counter = Counter(comb_list)  # 저절로 내림차순 정렬된 결괏값, 딕셔너리임

        if len(counter) != 0 and max(counter.values()) >= 2:
            answer += [''.join(key) for key in counter if counter[key] == max(counter.values())]

    return sorted(answer)


print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"], [2, 3, 5]))


''' 시간 초과 판정 코드

def solution(orders, course):
    answer = []

    # 주문된 코스 (사용된 알파벳)
    alphabets = set()
    alpha_cnt = [0] * 26  # 알파벳 카운트

    for order in orders:
        for o in order:
            alphabets.add(o)
            alpha_cnt[ord(o) - ord("A")] += 1

    del_list = set()

    for alpha in alphabets:
        if alpha_cnt[ord(alpha) - ord("A")] < 2:
            del_list.add(alpha)

    alphabets = list(alphabets - del_list)
    alphabets.sort()

    for num in course:
        perm_list = list(combinations(alphabets, num))  # num 개수만큼의 순열
        cnt = [0] * len(perm_list)

        for idx, perm in enumerate(perm_list):
            for order in orders:
                if set(perm).issubset(set(order)):
                    cnt[idx] += 1

        max_cnt = max(cnt)
        if max_cnt >= 2:
            for idx, value in enumerate(cnt):
                if value == max_cnt:
                    answer.append(''.join(perm_list[idx]))

    return sorted(answer)
    
'''
