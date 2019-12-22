'''
swea1824. 혁진이의 프로그램 검증
'''
tc = int(input())
for t in range(1, tc+1):
	R, C = map(int, input().split())
	mat = [0] * R
	for i in range(R):
		mat[i] = list(input())

	x, y = 0, 0
	dx = [0, 1, 0, -1]
	dy = [1, 0, -1, 0]
	dir_stat = 0
	M = 0
	