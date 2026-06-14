""" 피로도

분류 : DFS, 백트래킹, 완전탐색

전체 단계
ㄴ 방문 가능한 던전이면 방문
ㄴ DFS 로 다음 던전 탐색
ㄴ 탐색 종료 후 방문 취소
ㄴ 가능한 모든 방문 순서 확인 (완전 탐색)
ㄴ 최대 방문 개수 반환

시간복잡도 : O(n!)

입출력 예시
ㄴ k = 80
ㄴ dungeons = [[80,20],[50,40],[30,10]]
ㄴ result = 3

"""


# dfs 함수가 모든 경로를 전부 탐색한 뒤 최대 던전 수(max_count)를 반환할 것이다.
def dfs(k, dungeons, visited, count):

    # 현재의 count 를 max_count 로 저장
    # (더 이상 방문할 수 있는 던전이 없는 상황 대비)
    max_count = count

    for i, (limit, cost) in enumerate(dungeons):
        # 방문 불가능한 경우 체크
        if visited[i]:
            continue

        if k < limit:
            continue

        # 던전 방문 가능한 상태
        # 방문했다고 가정
        visited[i] = True

        max_count = max(
            max_count,
            dfs(k - cost, dungeons, visited, count + 1)
        )

        # 방문 취소
        visited[i] = False

    return max_count


def solution(k, dungeons):
    visited = [False] * len(dungeons)
    return dfs(k, dungeons, visited, 0)


k = 80
dungeons = [[80,20],[50,40],[30,10]]

print(solution(k, dungeons))