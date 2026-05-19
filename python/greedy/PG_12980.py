''' 점프와 순간 이동

분류 : Greedy, 비트마스킹/2진수

전체 단계
ㄴ N 이 0 이 될 때까지 역추적
ㄴ N = 짝수면 나누기 2 (순간이동 역 연산)
ㄴ N = 홀수면 빼기 1 (+ 배터리 사용량 증가)

왜 그리디 알고리즘을 사용하는가?
ㄴ 순간이동은 배터리 사용량이 0 이므로 항상 수행하는 것이 이득
ㄴ 홀수는 순간이동만으로 만들 수 없으므로 반드시 점프가 필요함
ㄴ 따라서 "짝수면 나누기, 홀수면 1 빼기" 선택이 항상 최적해로 이어진다.

비트마스킹/2진수 를 사용한다면?
ㄴ 점프가 발생하는 순간은 N 이 홀수일 때 뿐
ㄴ 즉, 점프 횟수 = N 의 2진수에서 1 의 개수 (2진수에서 홀수는 마지막 비트가 1이다)

입출력 예시
ㄴ n = 5, result = 2
ㄴ n = 5000, result = 5

'''


def greedy_solution(n):
    battery = 0

    while n != 0:
        if n % 2 == 0:
            n //= 2
        else:
            n -= 1
            battery += 1

    return battery


def binary_solution(n):
    return bin(n).count("1")


print(greedy_solution(5000))
print(binary_solution(5000))
