'''
swea2105. 디저트 카페

- 디저트를 가장 많이 먹을 수 있는 경로, 그 때의 디저트 수
- 임의의 한 카페에서 출발, 대각선 방향으로 이동
서로 다른 디저트를 먹으면서 다시 출발점으로 되돌아 옴
- 제약 조건
  4 <= N <= 20
  1 <= mat[i][j] <= 100
- (i, j)에서 투어 시작 시 꼭지점 좌표
  (i+a, j+a), (i+a+b, j+a-b), (i+b, j-b)
- Prunnig
  1. 같은 지점을 기준으로 시계 방향, 반시계 방향 중복되선 X
  2. 탐색해본 경로 값 저장, 이전 경로보다 짧은 경우 가지치기

'''
def tour(x, y):
	global max_path
	# 2. 대각선 길이 결정 - 대각선 최대 경로 길이 4N
	for a in range(1, N):
		for b in range(1, N):
			# 꼭짓점이 범위 안에 들어오는지 확인
			if x+a+b > N-1 or y+a > N-1 or y+a-b < 0 or y-b < 0 or (a+b)*2 < max_path:
				continue

			desserts = [False] * 101
			desserts[mat[x][y]] = True
			same_dessert = False
			nx, ny = x, y

			# 2번 카페까지 이동
			while (nx, ny) != (x+a, y+a):
				nx += 1
				ny += 1
				if desserts[mat[nx][ny]]:
					same_dessert = True
					break
				desserts[mat[nx][ny]] = True
			if same_dessert:
				continue

			# 3번 카페까지 이동
			while (nx, ny) != (x+a+b, y+a-b):
				nx += 1
				ny -= 1
				if desserts[mat[nx][ny]]:
					same_dessert = True
					break
				desserts[mat[nx][ny]] = True
			if same_dessert:
				continue

			# 4번 카페까지 이동
			while (nx, ny) != (x+b, y-b):
				nx -= 1
				ny -= 1
				if desserts[mat[nx][ny]]:
					same_dessert = True
					break
				desserts[mat[nx][ny]] = True
			if same_dessert:
				continue

			# 1번 카페(시작점)까지 이동
			while (nx, ny) != (x, y):
				nx -= 1
				ny += 1
				if (nx, ny) == (x, y):
					break
				if desserts[mat[nx][ny]]:
					same_dessert = True
					break
				desserts[mat[nx][ny]] = True
			if same_dessert:
				continue

			max_path = 2*(a+b)

	return max_path

tc = int(input())
for t in range(1, tc+1):
	N = int(input())
	mat = [0] * N
	for i in range(N):
		mat[i] = list(map(int, input().split()))

	# 1. 시작점 결정 - 모든 점을 기준으로 탐색 시작
	max_path = -1
	for i in range(N):
		for j in range(N):
			tour(i, j)
	print('#%d %d' % (t, max_path))
