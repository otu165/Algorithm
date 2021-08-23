''' 졸려
시간 : 208ms (~1초), 메모리 : 29328KB (~256MB)
분류 : 문자열
제출 : Python3
'''


def link(word):
    length = len(word)

    front = ""
    end = ""
    for i in range(length):
        if i % 2 == 0:
            front += word[i]
        else:
            end += word[i]

    return front + end[::-1]


# 입력
X = int(input())  # 눈을 깜빡인 횟수
word = input().rstrip()  # 이미 섞인 단어

# 풀이
'''
홀수번째 글자 앞으로 빼고,
짝수번째 글자 역순으로 붙이기 (== 원문 역순 후 홀수번째 글자 붙이기)
'''

answer = [word]

for i in range(X):
    word = link(word)

    if word in answer:
        break

    answer.append(word)

period = len(answer)  # 주기

# 출력
print(answer[X % period])