n = int(input())
factorial = lambda n: 1 if n <= 1 else n * factorial(n-1)
print(factorial(n))

'''
def factorial(n):
    if n <= 1:
        return 1
    return n*factorial(n-1)
'''