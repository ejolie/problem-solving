'''
2027. 그대로 출력하기

주어진 텍스트를 그대로 출력하세요.
'''
for i in range(0, 5):
    print('+' * i, end='')
    print('#', end='')
    print('+' * (4-i), end='')
    print()