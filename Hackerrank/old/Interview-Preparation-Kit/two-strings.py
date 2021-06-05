def twoStrings(s1, s2):
    return 'NO' if set(s1).isdisjoint(set(s2)) else 'YES'
# return 'YES' if any(i in s2 for i in s1) else 'NO'
# return 'YES' if any(map(lambda x: x in s2, s1)) else 'NO'
# return 'YES' if set(s1) & set(s2) else 'NO'

tc = int(input().strip())
for _ in range(tc):
    s1 = input().strip()
    s2 = input().strip()
    result = twoStrings(s1, s2)
    print(result)