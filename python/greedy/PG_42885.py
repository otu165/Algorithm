""" 구명보트

분류 : Greedy, 정렬, 투 포인터

전체 단계
ㄴ 사람들의 몸무게를 오름차순으로 정렬
ㄴ left = 가장 가벼운 사람 / right = 가장 무거운 사람을 가리킴
ㄴ 가장 가벼운 사람 + 가장 무거운 사람 <= limit 라면 둘이 함께 탑승
ㄴ limit 를 초과한다면 가장 무거운 사람 혼자 탑승

왜 그리디 알고리즘을 사용하는가?
ㄴ 가장 무거운 사람은 반드시 현재 보트에 태워야 함
ㄴ 가장 가벼운 사람과도 같이 탈 수 없다면, 다른 누구와도 같이 탈 수 없음
ㄴ 가장 가벼운 사람과 같이 탈 수 있다면 함께 태워도 보트 개수 측면에서 손해가 없음
ㄴ 따라서, "가장 무거운 사람을 기준으로 가장 가벼운 사람과 함께 태울 수 있는지 확인" 하는 선택이 최적해로 이어진다.

왜 투 포인터를 사용하는가?
ㄴ 정렬 후 양끝 같을 비교하면 가벼운 사람/무거운 사람을 빠르게 확인할 수 있음
ㄴ left, right 를 이동시키며 한 번의 순회로 모든 사람의 탑승 여부를 결정할 수 있음

입출력 예시
ㄴ people = [70, 50, 80, 50], limit = 100, result = 3
ㄴ people = [70, 80, 50], limit = 100, result = 3

"""

def solution(people, limit):
    answer = 0

    people.sort()
    left, right = 0, len(people) - 1

    while left <= right:

        # 두 사람이 같이 탑승하는 경우
        if people[left] + people[right] <= limit:
            left += 1
            right -= 1
        # 무거운 사람 혼자 탑승하는 경우
        else:
            right -= 1

        answer += 1

    return answer


print(solution([70, 50, 80, 50], 100))
print(solution([70, 80, 50], 100))
