'''
swea1204. 최빈수 구하기 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
	input()
	scores = list(map(int, input().split()))
	cnt = {}
	for s in scores:
		if s in cnt:
			cnt[s] += 1
		else:
			cnt[s] = 1
	ans = -1; maxcnt = -1
	for k, v in cnt.items():
		if v > maxcnt:
			maxcnt = v
			ans = k
	print('#{} {}'.format(t, ans))
