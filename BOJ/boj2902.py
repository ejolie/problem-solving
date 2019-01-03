import sys

st = sys.stdin.readline().rstrip().split('-')
for i in range(len(st)):
    st[i] = st[i][0].upper()
print(''.join(st))