'''
swea2805. 농작물 수확하기 (D3)

n = 7 (i = 0,1,2,3,4,5,6) 7 // 2 = 3
a[0][3]
a[1][2,3,4]
a[2][1,2,3,4,5]

a[4][1,2,3,4,5]
a[5][2,3,4]
a[6][3]
'''
tc = int(input())
for t in range(1, tc+1):
	N = int(input()) # 7
	MAP = [[] * N for _ in range(N)]
	for i in range(N):
		MAP[i] = [int(n) for n in list(input())]
	ans = 0; M = N//2 # 3
	for i in range(M): # 0, 1, 2
		ans += sum(MAP[i][M-i:M+i+1]) # 3, 2, 1 ~
	ans += sum(MAP[M])
	for i in range(M-1, -1, -1): # 2, 1, 0
		ans += sum(MAP[N-1-i][M-i:M+i+1]) # 4, 5, 6 ~ 
	print('#%d %d' % (t, ans))