""" 프로세스

분류 : 큐(deque), 구현, Counter

전체 단계
ㄴ 각 프로세스를 (인덱스, 우선순위) 형태로 큐에 저장
ㄴ Counter 로 우선순위별 개수 저장
ㄴ 반복하며 현재 가장 높은 우선순위(current_priority) 확인
ㄴ 현재 프로세스가 가장 높은 우선순위라면 pop / 아니라면 다시 append

시간복잡도
ㄴ 큐, Counter 생성 : O(n)
ㄴ while 반복 : 최악의 경우 O(n^2)
ㄴ 전체 : O(n^2)

입출력 예시
ㄴ priorities = [2, 1, 3, 2], location = 2, result = 1
ㄴ priorities = [1, 1, 9, 1, 1, 1], location = 0, result = 5

"""


from collections import deque, Counter

def solution(priorities, location):

    q = deque()

    for i, process in enumerate(priorities):
        q.append((i, process))

    cnt = 0 # 현재까지 실행된 프로세스 수
    priority_count = Counter(priorities)
    current_priority = 9 # 우선순위는 1 ~ 9 값을 가지므로, 일단 최대로 가정

    while q:
        # 현재 가장 높은 우선순위 구하기
        while priority_count[current_priority] == 0:
            current_priority -= 1

        i, process = q.popleft()

        # 우선순위가 더 높은 프로세스가 있는가
        if process < current_priority:
            q.append((i, process))
        else:
            cnt += 1
            priority_count[current_priority] -= 1

            if i == location:
                break

    return cnt

