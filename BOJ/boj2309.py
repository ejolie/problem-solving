'''
boj2309. 일곱 난쟁이
9C7 = 9C2
'''
def comb(n, r):
    if n == r or r == 0:
        return 1
    return comb(n-1, r-1) + comb(n-1, r)
h = [0] * 9
for i in range(9):
    h[i] = int(input())
# combination
print(comb(9, 2))
