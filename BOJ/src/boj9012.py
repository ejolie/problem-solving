from sys import stdin

def is_valid_ps(s):
    stack = []
    flag = True
    for i in range(len(s)):
        if s[i] == '(':
            stack.append(s[i])
        else:
            if len(stack) == 0:
                flag = False
                break
            else:
                stack.pop()
    if len(stack) > 0:
        flag = False
    return flag

for _ in range(int(stdin.readline())):
    s = stdin.readline().rstrip()
    print('YES' if is_valid_ps(s) else 'NO')