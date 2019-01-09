import sys

s, n = sys.stdin.readline().strip(), int(sys.stdin.readline().strip())
d, r = divmod(n, len(s))
result = s.count('a') * d + s[:r].count('a')

print(result)

'''
s : abcde
n : 13
abcde abcde abc

n / len(a) -> 몫, 나머지
abcde에서의 a개수 * 몫 + abcde에서 나머지만큼 뒤 a개수 
'''

# string.count(substring, start=..., end=...)
# s.count('a', 0, r) * (d + 1) + s.count('a', r) * d