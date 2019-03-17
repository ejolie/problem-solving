'''
swea5186. 이진수2 (D2)
0.625 = 0.5 (2^-1) + 0.125 (2^-3)
'''
tc = int(input())
for t in range(1, tc+1):
	N = float(input())
	ans = ''
	c = -1
	while N != 0:
		if c == -13:
			ans = 'overflow'
			break
		if N >= 2**c:
			ans += '1'
			N -= 2**c
		else:
			ans += '0'
		c -= 1
	print('#{} {}'.format(t, ans))