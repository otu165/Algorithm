
# Python 기초 문법 

## 1. 입력

```
# 입력 : 정수
import sys

input = int(sys.stdin.readline())
number = input
```
여러줄을 입력받는 경우 **input()** 을 사용하면 시간초과가 발생한다.

<br/>

```
# 입력 : 정수 정수
import sys

input = sys.stdin.readline()
a, b = map(int, input.split())
```

<br/>

```
# 입력 : 문자열 n줄
import sys

input = sys.stdin.readline()

n = int(input)
arr = [input.strip() for i in range(n)]

```
strip() 은 문자열 앞, 뒤의 공백을 제거한다.

<br/>

## 2. 조건부 표현식

조건문을 한 문장으로 사용하는 방식

```
score = 80
grade = "A" if score > 90 else "F"
```

<br/>

## 3. List Comprehension

문법 : [expression for item in list if conditional]

```
# 1.
[i for i in range(5)]  # [0, 1, 2, 3, 4]

# 2.
arr = [1, 2, 3, [4, 5], 6, "abc"]
[i for i in arr if type(i) == int]  # [1, 2, 3, 6]

# 3.
arr = ['abc', 'def', 'ghi']
[i[0].upper() for i in arr]  # ['A', 'D', 'G']
```

<br/>

## 4. Nested Comprehension

```
# 1.
[[] for i in range(3)]  # [[], [], []]

# 2.
[[j for j in range(3)] for i in range(2)]  # [[0, 1, 2], [0, 1, 2]]
```

<br/>


