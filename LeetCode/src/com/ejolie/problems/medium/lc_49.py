from collections import defaultdict
from typing import List

'''
49. Group Anagrams
'''
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        group = defaultdict(list)
        
        for s in strs:
            key = self._key(s)
            group[key].append(s)
            
        return [g for g in group.values()]
    
    def _key(self, s: str):
        return ''.join(sorted(s))

    def _tuple_key(self, s: str):
        check = [0] * 26
        for c in s:
            check[ord(c) - ord('a')] += 1
        return tuple(check)
