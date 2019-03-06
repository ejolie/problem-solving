'''
swea5178. 노드의 합 (D3)
'''
tc = int(input())
for t in range(1, tc+1):
    N, M, L = map(int, input().split())
    tree = [0 for _ in range(N+1)]
    for _ in range(M): # leaves
        i, n = map(int, input().split())
        tree[i] = n
    i = N // 2 # 1st parent node index
    while i > 0:
        tree[i] = tree[i*2]
        if i*2 + 1 <= N:
            tree[i] += tree[i*2 + 1]
        i -= 1 # prev parent node index
    print('#%d %d' % (t, tree[L]))