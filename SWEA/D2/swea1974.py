'''
swea1974. 스도쿠 검증
'''
tc = int(input())
for t in range(1, tc+1):
    ans = 1
    check = [[0] * 10 for _ in range(27)]
    for i in range(9): # row
        row = [int(n) for n in input().split()]
        if ans == 0: continue
        for j in range(9): # col
            num = row[j]
            i2 = 9 + j
            i3 = 18 + i//3 * 3 + j//3
            if check[i][num] == 0 and check[i2][num] == 0 and check[i3][num] == 0:
                check[i][num] += 1; check[i2][num] += 1; check[i3][num] += 1
            elif check[i][num] != 0 or check[i2][num] != 0 or check[i3][num] != 0:
                ans = 0; break
    print(f'#{t} {ans}')
    