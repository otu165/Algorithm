""" 기능개발

분류 : 스택/큐

전체 단계
ㄴ 각 작업의 완료일(day) 계산
ㄴ 이전 배포 기준일(done_day) 이하면 같은 배포로 묶음
ㄴ 더 크면 이전 묶음 개수 배포(append)

시간복잡도
ㄴ 배열 순회 : O(n)
ㄴ append() : O(1)
ㄴ 전체 : O(n)

입출력 예시
ㄴ progresses = [93, 30, 55]
ㄴ speeds = [1, 30, 5]
ㄴ result = [2, 1]

"""


def solution(progresses, speeds):

    done_day = 0  # 완료된 작업 기간
    cnt = 0       # 작업 수

    answer = [] # 자신보다 큰 값이 나오면 그 전의 값의 수를 세서 append

    for progress, speed in zip(progresses, speeds):
        # day = 현재 작업이 완료되기 위해 필요한 기간
        day = (100 - progress + speed - 1) // speed

        if day <= done_day:
            # 추가작업 없이 배포가능한 경우
            cnt += 1
        else:
            if 0 < cnt:
                # 배포할 작업이 있는 경우
                answer.append(cnt)

            # 현재 상태로 갱신
            done_day = day
            cnt = 1

    answer.append(cnt)

    return answer



progresses = [93, 30, 55]
speeds = [1, 30, 5]

print(solution(progresses, speeds))