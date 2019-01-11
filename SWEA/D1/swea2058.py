'''
2058. 자릿수 더하기

하나의 자연수를 입력 받아 
각 자릿수의 합을 계산하는 프로그램을 작성하라.
'''
n = input()
print(sum([int(i) for i in list(n)]))