'''
swea4874. Forth
'''
def calc_postfix(expr):
    stack = []
    for token in expr:
        if token not in '+-*/':
            stack.append(int(token))
        else:
            if len(stack) < 2:
                return 'error'
            b = stack.pop()
            a = stack.pop()
            if token == '+':
                res = a + b
            elif token == '-':
                res = a - b
            elif token == '*':
                res = a * b
            elif token == '/':
                res = a // b
            stack.append(res)
    if len(stack) != 1:
        return 'error'
    return stack.pop()

tc = int(input())
for t in range(1, tc+1):
    expr = input().split()
    print(f'#{t}', end=' ')
    print(calc_postfix(expr[:-1]))