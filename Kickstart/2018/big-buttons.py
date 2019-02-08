from sys import stdin

def solve(n, p):
    arr = []
    for _ in range(p):
        arr.append(stdin.readline().rstrip())

tc = int(stdin.readline().rstrip())
for t in range(1, tc+1):
    n, p = map(int, stdin.readline().rstrip())
    res = solve(n, p)
    print(f'Case #{t}: {res}')
