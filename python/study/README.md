
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

## 5. 리스트(mutable) vs 튜플(immutable)

 1. 리스트는 자료의 추가, 삭제, 변경이 빈번한 경우에는 mutable 자료구조가 좋다.
 2. 디버깅의 난이도는 immutable 이 쉽다.
 3. 데이터의 추가, 삭제, 변경이 이루어지지 않으면 immutable 이 더 적은 메모리를 사용한다.

<br/>

## 6. Tuple Comprehension

제너레이터를 생성한다.
```
a = (i**2 for i in range(3))

type(a)  # <class 'generator'>
```
제너레이터는 함수만을 정의해놓고 사용하는 순간 데이터를 메모리에 할당하므로 **때에 따라** 효율적인 사용이 가능하다. **(일회성)**

<br/>

## 7. Zip

```
# zip 을 이용한 데이터 묶음
x = "12"
y = "abc"
z = [1, 2, 3]

for i in zip(x, y, z):
	print(i)  # ("1", "a", 1) / ("2", "b", 2)
```
가장 짧은 객체의 길이를 따른다. 초과되는 원소는 무시된다.

<br/>

```
# * 을 이용한 데이터 unpacking
d_list = [[1, 2, 3], [1, 2, 3], [1, 2, 3]]

for i in zip(d_list[0], d_list[1], d_list[2]):
	print(i)  # (1, 1, 1) / (2, 2, 2) / (3, 3, 3)

for i in zip(*d_list):  # GOOD!
	print(i)  # (1, 1, 1) / (2, 2, 2) / (3, 3, 3)
```
\* 은 가장 바깥쪽의 리스트 한 겹을 벗겨준다.

<br/>

```
# zip 을 이용한 분리
x = [1, 2, 3]
y = ['a', 'b', 'c']
z = list(zip(x, y))  # [(1, 'a'), (2, 'b'), (3, 'c')]

X, Y = zip(*z)

print(X)  # (1, 2, 3)
print(Y)  # ('a', 'b', 'c')
```
