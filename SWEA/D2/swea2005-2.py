'''
swea2005. 파스칼의 삼각형 (D2)

a[n][1] = 1
a[n][n] = 1
a[n][k] = a[n-1][k-1] + a[n-1][k] (n, k >= 0)
'''
tc = int(input())
arr = [[1], [1,1]]
for n in range(3, 11):
	tmp = [0] * n
	tmp[0] = tmp[n-1] = 1
	for i in range(1, n-1):
		tmp[i] = arr[n-2][i-1] + arr[n-2][i]
	arr.append(tmp)
for t in range(1, tc+1):
	N = int(input())
	print('#%d' % t)
	for i in range(N):
		for j in range(i+1):
			print(arr[i][j], end=' ')
		print()