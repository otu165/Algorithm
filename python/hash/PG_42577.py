""" 전화번호 목록

분류 : 해시(set), 문자열(prefix)

전체 단계
ㄴ 전화번호의 접두어(prefix)를 생성
ㄴ 생성된 접두어가 set 에 존재하는지 확인

>> 현재 번호(num)가 다른 번호들의 접두어인지 확인하는게 아니라
num 을 제외한 다른 번호들이 num 의 접두어에 해당하는지 확인하는 코드

왜 set_pb 를 만드는가?
ㄴ set 탐색은 평균 O(1)
ㄴ list 탐색은 평균 O(n)
ㄴ 빠른 존재 여부 확인을 위해 set 사용

시간복잡도 : O(n)

입출력 예시
ㄴ phone_book = ["119", "97674223", "1195524421"], result = False
ㄴ phone_book = ["123","456","789"], result = True

"""


def solution(phone_book):
    set_pb = set(phone_book)

    for num in phone_book:
        prefix = ""

        for digit in num[:-1]:
            prefix += digit

            if prefix in set_pb:
                return False

    return True


phone_book = ["119", "97674223", "1195524421"]
print(solution(phone_book))