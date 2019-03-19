'''
swea3408. 세가지 합 구하기 (D3)

항의 개수 * (마지막 항 + 첫 항) // 2
'''
tc = int(input())
ans = []
for t in range(1, tc+1):
	N = int(input())
	a = N*(N+1)//2
	b = N**2
	c = N*(N+1)
	ans.append([a, b, c])
for t in range(tc):
	print('#{} {} {} {}'.format(t+1, ans[t][0], ans[t][1], ans[t][2]))