from sys import stdin

def _get_hourglass_sum(matrix, row, col):
    sum = 0
    sum += matrix[row-1][col-1]
    sum += matrix[row-1][col]
    sum += matrix[row-1][col+1]
    sum += matrix[row][col]
    sum += matrix[row+1][col-1]
    sum += matrix[row+1][col]
    sum += matrix[row+1][col+1]

    return sum

def hourglassSum(arr):
    max_hourglass_sum = -63
    for i in range(1, 5):
        for j in range(1, 5):
            current_hourglass_sum = _get_hourglass_sum(arr, i, j)
            if current_hourglass_sum > max_hourglass_sum:
                max_hourglass_sum = current_hourglass_sum
    return max_hourglass_sum

arr = []
for _ in range(6):
    arr_i = [int(i) for i in stdin.readline().strip().split(' ')]
    arr.append(arr_i)

result = hourglassSum(arr)
print(str(result))