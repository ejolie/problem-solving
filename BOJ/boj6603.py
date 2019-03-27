'''
boj6603. 로또
Backtracking

k = 8
S = 1 2 3 5 8 13 21 34
'''
from sys import stdin
def solve(idx, h):
	if h == 6:
		for i in range(6):
			print(res[i], end=' ')
		print()
		return

	for i in range(idx, K):
		res[h] = arr[i]
		solve(i + 1, h + 1)

while True:
	tmp = stdin.readline().rstrip().split()
	if tmp == ['0']:
		break
	K = tmp[0]
	arr = tmp[1:]
	res = [0] * 6
	for s in range(0, K - 5):
		solve(s, 0)