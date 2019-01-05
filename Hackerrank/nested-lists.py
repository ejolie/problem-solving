n = int(input())
studentList = [[input(), float(input())] for _ in range(n)]
secondMax = sorted(set([sc for nm, sc in studentList]))[1]
print('\n'.join(sorted([nm for nm, sc in studentList if secondMax == sc])))