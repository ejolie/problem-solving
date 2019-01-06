n = int(input())
studentList = [[input(), float(input())] for _ in range(n)]
studentList = sorted(studentList, key=lambda x: x[1])
secondMax = studentList[0][1]

for name, score in studentList:
  if score > secondMax:
    secondMax = score
    break

print('\n'.join([nm for nm, sc in sorted(studentList) if score == secondMax]))