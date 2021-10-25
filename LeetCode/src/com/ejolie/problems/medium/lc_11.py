from typing import List

"""
11. Container With Most Water

- 0 <= i < j <= len(height) - 1 일때,
  area = min(height[i], height[j]) * (j - i)

[Idea / Proof]
cf. https://leetcode.com/problems/container-with-most-water/discuss/6100/Simple-and-clear-proofexplanation
1. The widest container: j - i를 max 값으로, 즉 i = 0 && j = len(height) - 1 일 때
2. 1번 외의 container들은 1번보다 width가 좁지만 height는 커야 된다. (더 넓은 area를 가지려면)
3. height[i], height[j] 중 작은 height 가진 애를 버리고 다른 height으로 옮겨가면서 더 넓은 area를 가진 container를 찾는다.
"""
class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        max_area = 0
        
        while left < right:
            area =  min(height[left], height[right]) * (right - left)
            max_area = max(max_area, area)
            
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        
        return max_area