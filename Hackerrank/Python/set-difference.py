a = int(input())
set_a = set(map(int, input().split()))

b = int(input())
set_b = set(map(int, input().split()))

diff = set_a.difference(set_b)
print(len(diff))