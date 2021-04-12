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
