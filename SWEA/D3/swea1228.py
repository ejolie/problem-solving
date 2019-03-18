'''
swea1228. 암호문1 (D3)
'''
for t in range(1, 11):
    N = input()
    arr = input().split()
    M = input()
    tmp = input().split()
    i = 0
    while i < len(tmp):
        if tmp[i] == 'I':
            x, y = int(tmp[i+1]), int(tmp[i+2])
            nums = tmp[i+3:i+3+y]
            arr = arr[:x] + nums + arr[x:]
            i += y + 3
        else: i += 1
    print('#%d' % t, end=' ')
    for j in range(10):
        print(arr[j], end=' ')
    print()