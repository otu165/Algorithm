""" n^2 배열 자르기

분류 : 수학, 구현, 규칙 찾기

전체 단계
ㄴ n x n 2차원 배열의 규칙 파악
ㄴ 1차원 index 를 row / col 로 변환
ㄴ 해당 위치의 값 직접 계산
ㄴ left ~ right 구간 값만 저장 후 리턴

왜 전체 배열을 만들지 않는가?
ㄴ 1 <= n <= 10^7 이기 때문에 전체 배열 크기는 최대 10^14
ㄴ 메모리, 시간 초과가 발생하기 때문에 전체 배열을 만들면 안됨

2차원 배열 규칙
ㄴ arr[row][col] = max(row, col) + 1

입출력 예시
ㄴ n = 3, left = 2, right = 5, result = [3, 2, 2, 3]

"""


def solution(n, left, right):
    arr = []

    for i in range(left, right + 1):
        """
        n = 3 (3 X 3 배열 예시)
        
        1 2 3
        2 2 3
        3 3 3
        
        arr[0][0] = 1
        arr[0][1] = 2
        arr[0][2] = 3
        arr[1][0] = 2
        arr[1][1] = 2
        arr[1][2] = 3
        
        >>> 즉, arr[row][col] = max(row, col) + 1 규칙이 있다.
        
        """

        row = i // n
        col = i % n

        arr.append(max(row, col) + 1)

    return arr


print(solution(3, 2, 5))