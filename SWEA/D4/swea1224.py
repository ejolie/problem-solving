'''
swea1224. 계산기
'''
def icp(token): # in-coming priority
    if token == '*': return 2
    elif token == '+': return 1
    else: return 3

def isp(token): # in-stack priority
    if token == '*': return 2
    elif token == '+': return 1
    else: return 0

def infix_to_postfix(infixExpr):
    stack = []          # assistant stack
    postfixExpr = ""    # infix to postfix expr

    for token in infixExpr:
        if token in '0123456789':
            postfixExpr += token
        else:
            if postfixExpr == "":
                stack.append(token)
            elif token == ')':
                # pop until meet '('
                while stack[-1] != '(':
                    popItem = stack.pop()
                    if popItem != '(':
                        postfixExpr += popItem
                stack.pop()
            # when in-coming > in-stack
            elif icp(token) > isp(stack[-1]):
                stack.append(token)
            # when in-coming <= in-stack
            else:
                # pop until in-coming > in-stack
                while icp(token) <= isp(stack[-1]):
                    postfixExpr += stack.pop()
                stack.append(token)
    while stack != []:
        postfixExpr += stack.pop()
    return postfixExpr

def calc_postfix(postfixExpr):
    calc = []   # calculation result stack
    for char in postfixExpr:
        if char not in '+*':
            calc.append(int(char))
        else:
            b = calc.pop()
            a = calc.pop()
            if char == '+':
                res = a + b
            else:
                res = a * b
            calc.append(res)
    return calc.pop()

for t in range(1, 11):
    n = int(input())
    expr = list(input())
    res = calc_postfix(infix_to_postfix(expr))
    print(f'#{t} {res}')