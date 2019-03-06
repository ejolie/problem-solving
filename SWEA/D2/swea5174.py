'''
swea5174. subtree (D2)

주어진 이진 트리에서 노드 N을 루트로 하는
서브 트리에 속한 노드의 개수를 구하시오.
- 부모가 없는 노드 : 루트 노드
- 자식 노드가 0 : 자식이 없는 경우
'''
def preorder_count(root):
	global cnt
	if root:
		cnt += 1
		preorder_count(tree[root][0])
		preorder_count(tree[root][1])

tc = int(input())
for t in range(1, tc+1):
	cnt = 0
	E, N = map(int, input().split())
	tree = [[0, 0] for _ in range(E+2)]
	arr = [int(n) for n in input().split()]
	for i in range(len(arr) // 2):
		p, c = arr[i*2], arr[i*2+1]
		if not tree[p][0]:
			tree[p][0] = c
		else:
			tree[p][1] = c
	print(f'#{t}', end=' ')
	preorder_count(N)
	print(cnt)