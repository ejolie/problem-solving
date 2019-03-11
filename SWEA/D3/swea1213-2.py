'''
swea1213. String
'''
for t in range(1, 11):
    input()
    sub = input()
    string = input()
    m, n = len(string), len(sub)
    cnt = 0
    for i in range(m-n+1):
        if string[i:i+n] == sub:
            cnt += 1
    print('#%d %d' % (t, cnt))