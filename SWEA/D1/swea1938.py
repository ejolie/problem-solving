'''
1938. 아주 간단한 계산기 

두 개의 자연수를 입력받아 사칙연산을 수행하는 프로그램을 작성하라.
'''
a, b = [int(i) for i in input().split()]
print(a + b)
print(a - b)
print(a * b)
print(a // b)