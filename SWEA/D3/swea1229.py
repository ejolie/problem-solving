'''
swea1229. 암호문2 (D3)

#10 750997 372378 434453 546017 903649 285496 683627 815415 179846 725245
#내꺼 750997 372378 434453 112145 903649 285496 683627 815415 174006 725245
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
        elif tmp[i] == 'D':
            x, y = int(tmp[i+1]), int(tmp[i+2])
            arr = arr[:x+1] + arr[x+1+y:]
            i += 3
        else: i += 1
    print('#%d' % t, end=' ')
    for j in range(10):
        print(arr[j], end=' ')
    print()