''' 기둥과 보

기둥 설치 가능)
1. 바닥 위
2. 보의 한쪽 끝 위
3. 다른 기둥 위

보 설치 가능)
1. 왼쪽 or 오른쪽 끝 부분이 기둥 위
2. 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.

'''


def impossible(answer):
    COL, ROW = 0, 1

    for x, y, a in answer:
        if a == COL:  # 기둥 설치
            if y != 0 and (x - 1, y, ROW) not in answer and (x, y, ROW) not in answer and (x, y - 1, COL) not in answer:
                return True  # 불가능
        elif a == ROW:  # 보 설치
            if (x, y - 1, COL) not in answer and (x + 1, y - 1, COL) not in answer and \
                    not ((x - 1, y, ROW) in answer and (x + 1, y, ROW) in answer):
                return True  # 불가능

    return False


def solution(n, build_frame):
    answer = set()  # 집합을 이용해서 유일성 유지, 인덱스 신경 안쓰고 add / remove 연산 가능케 함

    for x, y, a, b in build_frame:  # (x, y) 좌표, a = (0 : 기둥, 1 : 보), b = (0 : 삭제, 1 : 설치)
        element = (x, y, a)

        if b == 1:
            answer.add(element)
            if impossible(answer):
                answer.remove(element)
        elif element in answer:
            answer.remove(element)
            if impossible(answer):
                answer.add(element)

    answer = list(map(list, answer))
    answer.sort(key=lambda x: (x[0], x[1], x[2]))

    return answer


print(solution(5, [[0, 0, 0, 1], [2, 0, 0, 1], [4, 0, 0, 1], [0, 1, 1, 1], [1, 1, 1, 1], [2, 1, 1, 1], [3, 1, 1, 1],
                   [2, 0, 0, 0], [1, 1, 1, 0], [2, 2, 0, 1]]))