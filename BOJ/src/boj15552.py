from sys import stdin

def add(a, b):
    return a + b

tc = int(input())
for i in range(tc):
    a, b = map(int, stdin.readline().split())
    result = add(a, b)
    print(result)