''' 볼 모으기

시간 제한 : 1초, 메모리 제한 : 512 MB

시간 : 280 ms, 메모리 : 29756 KB

'''

# 입력
number = int(input())
balls = input()

# 풀이
count_B = balls.count("B")
count_R = number - count_B

# 1. 연속된 왼쪽 RED 공 개수
red_left = 0
while red_left < number and balls[red_left] == "R":
    red_left += 1

# 2. 연속된 오른쪽 RED 공 개수
red_right = 0
while number - red_right - 1 >= 0 and balls[number - red_right - 1] == "R":
    red_right += 1

red = min(count_R - red_left, count_R - red_right)

# 3. 연속된 왼쪽 BLUE 공 개수
blue_left = 0
while blue_left < number and balls[blue_left] == "B":
    blue_left += 1

blue_right = 0
while number - blue_right - 1 >= 0 and balls[number - blue_right - 1] == "B":
    blue_right += 1

blue = min(count_B - blue_left, count_B - blue_right)

# 출력
print(min(red, blue))