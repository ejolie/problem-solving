n = int(input())
n_set = set(map(int, input().split()))

b = int(input())
b_set = set(map(int, input().split()))

union_set = n_set.union(b_set)
print(len(union_set))