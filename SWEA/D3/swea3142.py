'''
swea3142. 영준이와 신비한 뿔의 숲 (D3)
2x + y = N
x + y = M
y = M - x
2x + M - x = N
=> x = N - M (트윈혼)
=> y = 2*M - N (유니콘)
'''
tc = int(input())
for t in range(1, tc+1):
    N, M = map(int, input().split())
    print('#{} {} {}'.format(t, 2*M-N, N-M))