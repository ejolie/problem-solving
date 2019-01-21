from sys import stdin
left = [list(i) for i in [' 1qaz', '2wsx', '3edc', '4rfv5tgb']]
right = [list(i) for i in ['6yhn7ujm', '8ik,', '9ol.', "0p;/-[=]'"]]
result = [0] * 8
s = stdin.readline().rstrip().lower()
for i in range(len(s)):
    for j in range(4):
        if s[i] in left[j]:
            result[j] += 1
        elif s[i] in right[j]:
            result[j+4] += 1
for i in range(8):
    print(result[i])