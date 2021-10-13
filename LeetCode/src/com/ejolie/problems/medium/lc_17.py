from typing import List

"""
17. Letter Combinations of a Phone Number
"""
class Solution:
    mapping = {
        '2': 'abc', 
        '3': 'def', 
        '4': 'ghi', 
        '5': 'jkl', 
        '6': 'mno', 
        '7': 'pqrs', 
        '8': 'tuv', 
        '9': 'wxyz'
    }
        
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        
        result = []
        self._backtrack(0, '', digits, result)

        return result
    
    def _backtrack(self, i: int, comb: str, digits: str, result: List[str]) -> None:
        if i == len(digits):
            result.append(comb)
            return
        
        for letter in self.mapping[digits[i]]:
            self._backtrack(i + 1, comb + letter, digits, result)

solution = Solution()
assert solution.letterCombinations("23") == ["ad","ae","af","bd","be","bf","cd","ce","cf"]
assert solution.letterCombinations("") == []
assert solution.letterCombinations("2") == ["a","b","c"]