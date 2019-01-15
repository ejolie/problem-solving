'''
4834. 숫자 카드

0에서 9까지 숫자가 적힌 N장의 카드가 주어진다.
가장 많은 카드에 적힌 숫자와 카드가 몇 장인지 출력하는 프로그램을 만드시오. 
카드 장수가 같을 때는 적힌 숫자가 큰 쪽을 출력한다.
'''
tc = int(input())
for t in range(1, tc+1):
    n = int(input())
    nums = input()
    
    numsDic = {}
    for i in nums:
        numsDic[i] = nums.count(i)

    maxVal = max(numsDic.values())
    maxKey = max([k for k, v in numsDic.items() if v == maxVal])
   
    print(f'#{t} {maxKey} {maxVal}')