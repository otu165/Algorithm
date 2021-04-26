# Greedy (탐욕법)

- 현재 상황에서 **지금 당장 좋은 것**만 고르는 방법
- 최적해를 얻을 수 있다는 **정당성**을 부여할 수 있어야 함

<br/>

# Combination (조합)

``` Python
# 조합의 수(nCr) : nPr / r!

from itertools import combinations

ball_list = ['red', 'blue']
print(list(combinations(ball_list, 2)))  # [('red', 'blue')]
```
- 서로 다른 n 개에서 순서에 상관 없이 서로 다른 r 개를 선택하는 것

<br/>

## 중복 조합
``` Python
from itertools import combinations_with_replacement as cwr

ball_list = ['red', 'blue', 'yellow']
print(list(cwr(ball_list, 2)))

# 출력
# [
#	('red', 'red'), ('red', 'blue'), ('red', 'yellow'), 
#	('blue', 'blue'), ('blue', 'yellow'), 
#	('yellow', 'yellow')
# ]
```
<br/>

# Permutation (순열)

``` Python
# 순열의 수(nPr) : n * (n - 1) * ... * (n - r + 1)

from itertools import permutations

ball_list = ['red', 'blue']
print(list(permutations(ball_list, 2)))  # [('red', 'blue'), ('blue', 'red')]
```
- 서로 다른 n 개에서 서로 다른 r 개를 선택하여 일렬로 나열하는 것
- 순서를 고려함

<br/>

## 중복 순열
``` Python
from itertools import product

ball_list = ['red', 'blue', 'yellow']
print(list(product(ball_list, repeat=3)))  

# 출력
# [
#	('red', 'red'), ('red', 'blue'), ('red', 'yellow'), 
#	('blue', 'red'), ('blue', 'blue'), ('blue', 'yellow'), 
#	('yellow', 'red'), ('yellow', 'blue'), ('yellow', 'yellow')
# ]
```

<br/>



## DFS (Depth-First Search)

``` python
def dfs(node):  # node = 현재 방문할 노드
	visited[node] = True
	print(v, end=' ')
	
	# 현재 노드와 연결된 다른 노드를 재귀적으로 방문
	for i in graph[node]:  # graph 리스트는 인접 리스트 형식으로 표현된 그래프
		if not visited[i]:  # i 노드를 방문하지 않았다면
			dfs(i)  # 방문
```

- **깊이 우선** 그래프 탐색 알고리즘
- **스택 자료구조** 또는 **재귀 함수**를 이용함

<br/>

## BFS (Breadth-First Search)
``` python
from collections import deque

def bfs(node):  # start = 첫 시작점이 되는 노드
	q = deque()
	q.append(node)  # 큐에 시작 노드를 넣어줌
	
	while q:  # q 에 남은 노드가 없을 때까지 반복
		node = q.popleft()  # 지금 방문한 노드
		print(node, end=' ')
		
		for i in graph[x]:  # 인접 노드들에 대하여
			if not visited[i]:  # 방문하지 않은 노드가 있다면
				q.append(i)  # 방문하기 위해 큐에 집어넣고
				visited[i] = True  # 해당 노드를 방문했다고 표시
```

- **너비 우선** 그래프 탐색 알고리즘
- **큐 자료구조**를 이용함

<br/>

## 선택정렬(Selection Sort)
``` python
arr = [5, 3, 1, 2, 4]

for i in range(len(arr) - 1):
	idx = i
	for j in range(i + 1, len(arr)):
		if arr[j] < arr[idx]:
			idx = j
			
	arr[i], arr[idx] = arr[idx], arr[i]
	
print(arr)  # [1, 2, 3, 4, 5]
```
- 처리되지 않은 데이터 중 가장 작은 데이터와, 맨 앞의 데이터를 바꾸는 것을 반복함.
- 시간복잡도 : O(N^2)

<br/>

## 삽입정렬(Insertion Sort)
``` python
arr = [5, 3, 1, 2, 4]

for i in range(1, len(arr)):
	for j in range(i, 0, -1):
		if arr[j] < arr[j - 1]:
			arr[j], arr[j - 1] = arr[j - 1], arr[j]
		else:
			break
			
print(arr)  # [1, 2, 3, 4, 5]
		
```
- 처리되지 않은 데이터를 하나씩 골라 적절한 위치에 삽입한다.
- 평균 시간복잡도 : O(N^2), 최선의 경우 시간복잡도 : O(N)

<br/>

## 퀵 정렬(Quick Sort)
``` python
def quick_sort(arr):
	if len(arr) <= 1:
		return arr
	
	pivot = arr[0]
	rest = arr[1:]
	
	left = [x for x in rest if x < pivot]
	right = [x for x in rest if x >= pivot]
	
	return quick_sort(left) + list(pivot) + quick_sort(right)


arr = [5, 3, 1, 2, 4]
print(quick_sort(arr))  # [1, 2, 3, 4, 5]

```
- 기준 데이터(pivot)를 설정하고, 그 기준보다 큰 데이터와 작은 데이터의 위치를 바꾸는 방법
- 평균 시간복잡도 : O(NlogN), 최악의 경우 시간복잡도 : O(N^2)

<br/>

