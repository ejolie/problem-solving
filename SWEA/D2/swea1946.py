'''
1946. 간단한 압축 풀기

'''
tc = int(input())
for t in range(1, tc+1):
    n = int(input())
    st = ''
    for i in range(n):
        a, b = input().split()
        st += a * int(b)
    print(f'#{t}')
    for i in range(len(st)):
        print(st[i], end='')
        if i % 10 == 9:
            print()
    print()