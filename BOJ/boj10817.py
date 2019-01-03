import sys

a, b, c = map(int, sys.stdin.readline().split())

if (a <= b and b <= c) or (c <= b and b <= a):
    print(b)
elif (b <= a and a <= c) or (c <= a and a <= b):
    print(a)
else:
    print(c)