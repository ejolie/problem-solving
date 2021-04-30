import sys

while True:
    st = sys.stdin.readline().rstrip()
    if st == 'END':
        break
    
    li = list(st)
    for i in range(len(li) // 2):
        li[i], li[-1-i] = li[-1-i], li[i]
    print(''.join(li))