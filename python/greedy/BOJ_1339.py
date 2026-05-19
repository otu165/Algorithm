''' 단어 수학
시간 : 68ms (~2초), 메모리 : 29200KB (~256MB)
분류 : greedy
'''

import sys
input = sys.stdin.readline

# 입력
N = int(input())  # 단어의 개수
arr = [list(input().strip()) for _ in range(N)]

# 풀이
alphabet = []
for word in arr:
    for a in word:
        if a not in alphabet:
            alphabet.append(a)

value_list = []
for a in alphabet:
    value = 0
    for word in arr:
        if a not in word:  # 알파벳 없으면 넘어감
            continue

        s = ""
        for w in word:
            s += "1" if w == a else "0"
        value += int(s)

    value_list.append(value)

value_list.sort(reverse=True)  # 내림차순 정렬

answer = 0
value = 9
for s in value_list:
    answer += value * s
    value -= 1

# 출력
print(answer)

