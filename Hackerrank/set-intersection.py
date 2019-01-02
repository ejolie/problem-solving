a = int(input())
set_a = set(map(int, input().split()))

b = int(input())
set_b = set(map(int, input().split()))

inter = set_a.intersection(set_b)
print(len(inter))