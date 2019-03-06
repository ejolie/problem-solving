'''
swea1232. 사칙연산 (D4)
'''
def postorder(root):
    if root != 0:
        if tree[root][1] != 0: # left
            postorder(tree[root][1])
        if tree[root][2] != 0: # right
            postorder(tree[root][2])
        pstack.append(tree[root][0]) # root

for t in range(1, 11):
    N = int(input())
    tree = [[0, 0, 0] for _ in range(N+1)] # key, left, right
    for i in range(1, N+1):
        tmp = input().split()
        if len(tmp) == 4:
            tree[int(tmp[0])] = [tmp[1], int(tmp[2]), int(tmp[3])]
        else: tree[int(tmp[0])][0] = int(tmp[1])
    pstack = []
    res = []
    postorder(1)
    for tk in pstack:
        if type(tk) == int:
            res.append(tk)
        else:
            b = res.pop()
            a = res.pop()
            if tk == '+':
                res.append(a + b)
            elif tk == '-':
                res.append(a - b)
            elif tk == '*':
                res.append(a * b)
            else:
                res.append(a / b)
    print('#%d %d' % (t, res.pop()))