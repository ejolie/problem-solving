'''
boj6603. 로또
Backtracking
'''
from sys import stdin
def solve(v, cnt):
	if cnt == 6:
		for i in range(6):
			print(res[i], end=' ')
		print()
		return
	for i in range(v, K):
		res[cnt] = arr[i]
		solve(i + 1, cnt + 1)

while True:
	tmp = stdin.readline().rstrip().split()
	if tmp == ['0']:
		break
	K = int(tmp[0])
	arr = tmp[1:]
	res = [0] * 6
	solve(0, 0)
	print()