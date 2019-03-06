from LinkedBinaryTree import BinaryTree

def buildParseTree(fpexp):
    fplist = fpexp.split()
    pStack = []
    eTree = BinaryTree('')
    pStack.append(eTree)
    currentTree = eTree

    for i in fplist:
        if i == '(':
            currentTree.insertLeft('')
            pStack.push(currentTree)
            currentTree = currentTree.leftChild
        elif i not in ['+', '-', '*', '/', ')']:
            currentTree.key = int(i)
            parent = pStack.pop()
            currentTree = parent
        elif i in ['+', '-', '*', '/']:
            currentTree.key = i
            currentTree.rightChild = ''
            pStack.append(currentTree)
            currentTree = currentTree.rightChild
        elif i == ')':
            currentTree = pStack.pop()
        else:
            raise ValueError
    return eTree

pt = buildParseTree('( ( 10 + 5 ) * 3 )')
pt.postorder()