'''
swea1289. 원재의 메모리 복구하기

원래 상태
0011
100

초기화
0000 -> 2번째 비트, 0011
000 -> 3번째 비트, 111 -> 2번째 비트, 100
'''
tc = int(input())
for t in range(1, tc+1):
	st = list(input())
	tmp = ['0'] * len(st)
	cnt = 0
	for i in range(len(st)):
		if st[i] != tmp[i]:
			cnt += 1
			for j in range(i, len(st)):
				tmp[j] = st[i]
	print('#{} {}'.format(t, cnt))