""" 베스트 앨범

분류 : 해시, 정렬

왜 defaultdict 해시를 사용하는가?
ㄴ key 존재 여부 검사 없이 append, += 가능

왜 d2 를 -x[1] 기준 정렬하는가?
ㄴ python sorted 는 기본적으로 오름차순 정렬을 함
ㄴ 값 부호를 반전시킴으로서 reverse 옵션 없이 내림차순 정렬이 가능해짐

시간복잡도 : O(n log n)

입출력 예시
ㄴ genres = ["classic", "pop", "classic", "classic", "pop"]
ㄴ plays  = [500, 600, 150, 800, 2500]
ㄴ result = [4, 1, 3, 0]

"""


from collections import defaultdict


def solution(genres, plays):

    d1 = defaultdict(list)  # { 장르 : (고유번호, 재생수) }
    d2 = defaultdict(int)   # { 장르 : 재생수 총합 }

    for i, (genre, play) in enumerate(zip(genres, plays)):
        d1[genre].append((i, play))
        d2[genre] += play

    answer = []

    # d2 > "value(재생수) 기준 내림차순" 정렬
    for genre, _ in sorted(d2.items(), key=lambda x: -x[1]):

        # d1 > "play(재생수) 기준 내림차순 + i(고유번호) 기준 오름차순" 정렬
        arr = sorted(d1[genre], key=lambda x: (-x[1], x[0]))
        answer.extend(i for i, _ in arr[:2])

    return answer


genres = ["classic", "pop", "classic", "classic", "pop"]
plays = [500, 600, 150, 800, 2500]

print(solution(genres, plays))