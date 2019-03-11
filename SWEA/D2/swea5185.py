'''
swea5185. 이진수 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    N, hexn = input().split()
    N = int(N)
    binn = ''
    for i in range(N):
        for j in range(3, -1, -1):
            if int(hexn[i], 16) & 1 << j:
                binn += '1'
            else: binn += '0'
    print('#%d %s' % (t, binn))