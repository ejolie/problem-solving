'''
boj9663. N-Queen
Backtracking
N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제이다.
N이 주어졌을 때, 퀸을 놓는 방법의 수를 구하는 프로그램을 작성하시오.

00 01 02 03 04
10 11 12 13 14
20 21 22 23 24
30 31 32 33 34
40 41 42 43 44
'''
def promising(x, y): # 가로, 세로, 대각선 상에 겹치는 거 X
	# 가로, 세로
	rowcnt, colcnt = 0, 0
	for i in range(N):
		if board[i][y]: rowcnt += 1
		if board[x][i]: colcnt += 1

	# 대각선
	rdcnt, ldcnt = 0, 0

	if rowcnt > 1 or colcnt > 1 or rdcnt > 1 or ldcnt > 1:
		return False
	return True

def dfs(r):
	global cnt
	if r == N:
		cnt += 1
		return
	for i in range(r, N):
		for j in range(N):
			if promising(i, j):
				board[i][j] = 1
				dfs(r + 1)
				board[i][j] = 0

N = int(input())
board = [[0] * N for _ in range(N)]
cnt = 0
dfs(0)
print(cnt)
