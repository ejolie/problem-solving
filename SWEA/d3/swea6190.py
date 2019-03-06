'''
swea6190. 정곤이의 단조 증가하는 수
'''
def check(num): # 1234
	is_greater = True
	if not num // 10:
		return is_greater
	last = 9
	while num > 0:
		rest = num % 10 # r = 3
		if rest > last:
			is_greater = False
			break
		last = rest # last = 4
		num //= 10
	return is_greater

tc = int(input())
for t in range(1, tc+1):
	N = int(input())
	nums = [0]
	nums += map(int, input().split())
	maxn = -1
	for i in range(1, N): # 1/2/3
		for j in range(i+1, N+1): # 234/34/4
			tmpn = nums[i] * nums[j]
			if check(tmpn) and tmpn > maxn:
				maxn = tmpn
	print('#%d %d' % (t, maxn))