'''
boj2580. 스도쿠
Backtracking
'''
from sys import stdin
def backtrack(i):
	global flag
	if i == len(zeros):
		flag = True
		return
	x, y = zeros[i]
	for n in range(1, 10):
		if not check[x][n] and not check[9 + y][n] and not check[18 + x//3 * 3 + y//3][n]:
			sudoku[x][y] = n
			check[x][n] = 1
			check[9 + y][n] = 1
			check[18 + x//3 * 3 + y//3][n] = 1
			backtrack(i + 1)
			if flag:
				break
			sudoku[x][y] = 0
			check[x][n] = 0
			check[9 + y][n] = 0
			check[18 + x//3 * 3 + y//3][n] = 0
	return

check = [[0] * 10 for _ in range(27)]
sudoku = [0] * 9
zeros = []
for i in range(9):
	sudoku[i] = list(map(int, stdin.readline().rstrip().split()))
	for j in range(9):
		if sudoku[i][j]:
			check[i][sudoku[i][j]] = 1
			check[9 + j][sudoku[i][j]] = 1
			check[18 + i//3 * 3 + j//3][sudoku[i][j]] = 1
		else: 
			zeros.append((i, j))
flag = False
backtrack(0)
for su in sudoku:
	for n in su:
		print(n, end=' ')
	print()





