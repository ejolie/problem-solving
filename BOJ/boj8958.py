def solve(string):
    total = 0
    cnt = 0
    for i in range(len(string)):
        if string[i] == 'O':
            cnt += 1
        elif string[i] == 'X':
            cnt = 0
        total += cnt
    return total

if __name__ == '__main__':
    tc = int(input())
    for i in range(tc):
        string = input()
        result = solve(string)
        print(result)