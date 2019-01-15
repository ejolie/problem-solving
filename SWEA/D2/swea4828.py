'''
4828. min max

N개의 양의 정수에서 가장 큰 수와 가장 작은 수의 차이를 출력하시오.
'''
tc = int(input())
for t in range(1, tc+1):
        n = int(input())
        arr = [int(item) for item in input().split()]
        max_num = max(arr)
        min_num = min(arr)
        print('#{0} {1}'.format(t, max_num - min_num))