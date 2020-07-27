'''
49094. 태민이의 취미
sum of n^3 = (n(n+1)/2)^2
'''
n = int(input())
DIV = 1000000007
total = (n * (n + 1) // 2) ** 2 % DIV
print(total)