'''
swea2007. 패턴 마디의 길이 (D2)
'''
tc = int(input())
for t in range(1, tc+1):
    string = input()
    for i in range(1, len(string)):
        if string[0:i] == string[i:2*i]:
            ans = i
            break
    print('#%d %d' % (t, ans))