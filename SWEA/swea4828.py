def test_case(tc):
    for t in range(1, tc+1):
        n = int(input())
        arr = [int(item) for item in input().split()]
        max_num = max(arr)
        min_num = min(arr)
        print('#{0} {1}'.format(t, max_num - min_num))

if __name__ == '__main__':
    tc = int(input())
    test_case(tc)