'''
swea3750. Digit sum (D3)
'''
tc = int(input())
for t in range(1, tc+1):
    num = input()
    while len(num) > 1:
        tmp = 0
        for n in num:
            tmp += int(n)
        num = str(tmp)
    print('#{} {}'.format(t, num))