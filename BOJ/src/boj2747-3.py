def fib(n):
    a, b = 1, 0
    for _ in range(n):
        a, b = b, a+b
    return b
n = int(input())
print(fib(n))