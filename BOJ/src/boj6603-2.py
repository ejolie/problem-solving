'''
boj6603. 로또
'''
def solve(v, cnt):
    if cnt == 6:
        for n in res:
            print(n, end=' ')
        print()
        return
    for i in range(v, K):
        res[cnt] = arr[i]
        solve(i + 1, cnt + 1)

while True:
    tmp = input()
    if tmp == '0':
        break
    tmp = tmp.split()
    K = int(tmp[0])
    arr = tmp[1:]
    res = [0] * 6
    for s in range(K-5):
        res[0] = arr[s]
        solve(s + 1, 1)
    print()