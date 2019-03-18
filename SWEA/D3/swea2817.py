'''
swea2817. 부분 수열의 합 (D3)
'''
tc = int(input())
for t in range(1, tc+1):
	N, K = map(int, input().split())
	arr = list(map(int, input().split()))
	cnt = 0
	for i in range(1, 1 << N): # num of all subsets
		tmpsum = 0
		for j in range(N):
			if i & (1 << j): # check if arr[j] exists
				tmpsum += arr[j]
		if tmpsum == K:
			cnt += 1
	print('#{} {}'.format(t, cnt))