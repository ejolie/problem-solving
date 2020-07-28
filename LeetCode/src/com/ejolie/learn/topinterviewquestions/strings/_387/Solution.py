'''
387. First Unique Character in a String
'''
import collections


class Solution:
    def firstUniqChar(self, s: str) -> int:
        dic = {}
        for i in range(len(s)):
            if s[i] not in dic:
                dic[s[i]] = 1
            else:
                dic[s[i]] += 1

        for i in range(len(s)):
            if dic[s[i]] == 1:
                return i
        return -1

    def firstUniqChar_pythonic(self, s: str) -> int:
        count = collections.Counter(s)

        for idx, ch in enumerate(s):
            if count[ch] == 1:
                return idx
        return -1


solution = Solution()
print(solution.firstUniqChar_pythonic("leetcode"))
