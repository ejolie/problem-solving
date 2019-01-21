from sys import stdin
a, b = stdin.readline().rstrip().split()
maxn = int(a.replace('5', '6')) + int(b.replace('5', '6'))
minn = int(a.replace('6', '5')) + int(b.replace('6', '5'))
print(f'{minn} {maxn}')