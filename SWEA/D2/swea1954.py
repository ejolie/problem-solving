'''
swea1954. 달팽이 숫자
'''
tc = int(input())
for t in range(1, tc+1):
	N = int(input())
	nums = [n for n in range(1, N**2+1)]
	ans = [[0] * N for _ in range(N)]

	x, y = 0, 0
	dx = [0, 1, 0, -1]
	dy = [1, 0, -1, 0]
	dir_stat = 0 # 0: right, 1: down, 2: left, 3: up
	for i in range(N**2):
		ans[x][y] = nums[i]
		x += dx[dir_stat]
		y += dy[dir_stat]
		if x < 0 or x > N-1 or y < 0 or y > N-1 or ans[x][y]:
			x -= dx[dir_stat]
			y -= dy[dir_stat]
			dir_stat = (dir_stat + 1) % 4
			x += dx[dir_stat]
			y += dy[dir_stat]
	print('#%d' % t)
	for i in range(N):
		for j in range(N):
			print(ans[i][j], end=' ')
		print()