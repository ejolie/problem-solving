def selection_sort(data, n):
  for i in range(n):
    min = data[i]
    index = i
    # find min in the rest of arr
    for j in range(i+1, n):
      if data[j] < min:
        min = data[j]
        index = j
    # swap 1st item of arr and min
    tmp = data[i]
    data[i] = min
    data[index] = tmp
  # print sorted arr to str
  print(" ".join([str(item) for item in data])) # print(" ".join(map(str, data)))

if __name__ == '__main__':
  n = int(input())
  data = [int(item) for item in input().split()]
  selection_sort(data, n)