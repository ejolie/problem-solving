'''
1936. 1대1 가위바위보

A와 B중에 누가 이겼는지 판별해보자. 단, 비기는 경우는 없다.
'''
a, b = [int(i) for i in input().split()]
print('A' if a > b else 'B')