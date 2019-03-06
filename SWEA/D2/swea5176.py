'''
swea5176. 이진탐색 (D2)
'''
def inorder(root):
	global num
	if root:
		if 2*root <= N: inorder(2*root)
		tree[root] = num
		num += 1
		if 2*root + 1 <= N: inorder(2*root + 1)


tc = int(input())
for t in range(1, tc+1):
	N = int(input())
	num = 1
	tree = [0 for i in range(N+1)]
	inorder(1)
	print('#{0} {1} {2}'.format(t, tree[1], tree[N // 2]))