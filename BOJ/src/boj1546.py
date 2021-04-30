import sys

n = int(input())
results = list(map(int, sys.stdin.readline().split()))

m = max(results)
newResults = [i/m*100 for i in results]
avg = sum(newResults) / n
print('{0:.2f}'.format(avg))