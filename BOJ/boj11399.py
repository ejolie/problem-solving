from sys import stdin

n = int(stdin.readline())
times = [int(i) for i in stdin.readline().rstrip().split()]
times.sort()
total = 0
for i in range(n):
    total += times[i] * (n - i)
print(total)

'''
3 1 4 3 2
1 2 3 3 4  # sorted

0 : 1
1 : 1 + 2
2 : 1 + 2 + 3
3 : 1 + 2 + 3 + 3
4 : 1 + 2 + 3 + 3 + 4
'''