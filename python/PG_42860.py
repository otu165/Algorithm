''' 조이스틱

좌우 : 커서이동
상하 : 알파벳 변환

return 이름에 대해 조이스틱 조작 횟수의 최솟값
'''


def solution(name):
    if name.count("A") == len(name):
        return 0

    cursor, answer = 0, 0

    visited = [0] * len(name)
    for idx, value in enumerate(name):
        if value == "A":
            visited[idx] = 1

    while True:
        # 1. 알파벳 변환
        a, z = ord("A"), ord("Z")

        if ord(name[cursor]) <= (a + z) // 2:
            answer += ord(name[cursor]) - a
        else:
            answer += z - ord(name[cursor]) + 1

        visited[cursor] = 1

        # 2. 종료조건
        if visited.count(1) == len(name):
            return answer

        # 3. 커서 이동
        left, right = cursor - 1, cursor + 1
        left_move, right_move = 1, 1

        while visited[left] == 1:
            left -= 1
            left_move += 1

        while visited[right] == 1:
            right += 1
            right_move += 1

        if left_move < right_move:  # 왼쪽 이동
            cursor = left
            answer += left_move
        else:
            cursor = right
            answer += right_move


print(solution("JAN"))