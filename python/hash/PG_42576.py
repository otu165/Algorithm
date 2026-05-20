""" 완주하지 못한 선수

분류 : 해시

전체 단계
ㄴ participant 를 Counter 로 변환
ㄴ completion 을 Counter 로 변환
ㄴ 두 Counter 객체를 빼기 연산
ㄴ 남아있는 key 가 완주하지 못한 선수

시간복잡도
ㄴ Counter 생성 : O(n)
ㄴ Counter 빼기 : O(n)
ㄴ key 추출 : O(1)
ㄴ 전체 : O(n)

입출력 예시
ㄴ participant = ["leo", "kiki", "eden"]
ㄴ completion = ["eden", "kiki"]
ㄴ result = "leo"

"""


from collections import Counter

def solution(participant, completion):
    p = Counter(participant)
    c = Counter(completion)

    return list(p-c)[0]


participant = ["leo", "kiki", "eden"]
completion = ["eden", "kiki"]

print(solution(participant, completion))
