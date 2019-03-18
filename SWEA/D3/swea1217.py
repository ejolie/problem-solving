'''
swea1217. 거듭 제곱 (D3)
'''
def pow(N, M):
    if M == 0: return 1
    return N * pow(N, M-1)

for t in range(1, 11):
    input()
    N, M = map(int, input().split())
    print('#{} {}'.format(t, pow(N, M)))