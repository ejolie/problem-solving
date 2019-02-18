from Stack import Stack

def infixToPostfix(infixExpr):
    prec = {
        "*": 3,
        "/": 3,
        "+": 2,
        "-": 2,
        "(": 1
    }
    opStack = Stack()
    postfixList = []
    tokenList = infixExpr.split()
