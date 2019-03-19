'''
swea4299. 태혁이의 사랑은 타이밍 (D3)
'''
tc = int(input())
for t in range(1, tc+1):
	D, H, M = map(int, input().split())
	ans = (D-11)*24*60 + (H-11)*60 + M-11
	if ans < 0:
		ans = -1
	print('#{} {}'.format(t, ans))