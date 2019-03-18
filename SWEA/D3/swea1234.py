'''
swea1234. 비밀번호 (D3)
'''
for t in range(1, 11):
    N, S = input().split()
    stack = []
    for i in range(int(N)):
        if stack == [] or stack[-1] != S[i]:
            stack.append(S[i])
        elif stack[-1] == S[i]:
            stack.pop()
    print('#{} {}'.format(t, ''.join(stack)))