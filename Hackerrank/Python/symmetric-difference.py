m = int(input())
m_set = set(map(int, input().split()))

n = int(input())
n_set = set(map(int, input().split()))

diff = sorted(m_set.symmetric_difference(n_set))
for item in diff:
  print(item)