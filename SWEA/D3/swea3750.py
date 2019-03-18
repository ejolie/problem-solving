'''
swea3750. Digit sum (D3)
'''
res = []
tc = int(input())
for t in range(tc):
    num = input()
    while len(num) > 1:
        tmp = 0
        for n in num:
            tmp += int(n)
        num = str(tmp)
    res.append(num)
for t in range(tc):
    print('#{} {}'.format(t+1, res[t]))