'''
swea1984. 중간 평균값 구하기 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    nums = list(map(int, input().split()))
    nums.remove(max(nums))
    nums.remove(min(nums))
    print('#%d %d' % (t, round(sum(nums)/8)))