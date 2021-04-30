from sys import stdin
m = int(stdin.readline().rstrip())
n = int(stdin.readline().rstrip())
result = [i for i in range(m, n+1) if int(i**0.5) ** 2 == i]
print(-1 if result == [] else f'{sum(result)}\n{min(result)}')