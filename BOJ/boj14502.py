'''
boj14502. 연구소

- 바이러스(2) : 상하좌우로 인접한 빈 칸(0)으로 퍼져나감
- 새로 세울 수 있는 벽(1)의 개수 : 3개
- 안전 영역 크기의 최댓값
'''
from collections import deque
N, M = map(int, input().split())
mat = [0] * N
for i in range(N):
	mat[i] = list(map(int, input().split()))