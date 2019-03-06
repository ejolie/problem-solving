'''
swea1231. 중위순회 (D4)
'''
def inorder(root):
	if root: # if root != 0
		inorder(tree[root][1]) # left
		print(tree[root][0], end='')
		inorder(tree[root][2]) # right

for t in range(1, 11):
	N = int(input())
	tree = [[0] * 3 for _ in range(N+1)]
	for i in range(N):
		arr = input().split()
		n = int(arr[0])
		tree[n][0] = arr[1]
		if len(arr) == 3:
			tree[n][1] = int(arr[2])
		elif len(arr) == 4:
		 	tree[n][1] = int(arr[2]); tree[n][2] = int(arr[3])
	print(f'#{t}', end=' ')
	inorder(1)
	print()