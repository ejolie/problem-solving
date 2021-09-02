from typing import List, Optional

"""
Day2. Unique Binary Search Trees II
"""
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def generateTrees(self, n: int) -> List[Optional[TreeNode]]:
        return self.makeBST(start=1, end=n)
    
    def makeBST(self, start: int, end: int) -> List[TreeNode]:
        if start > end:
            return [None]
        
        allTrees = []
        for val in range(start, end+1):
            allLeftTrees = self.makeBST(start=start, end=val-1)
            allRightTrees = self.makeBST(start=val+1, end=end)
            
            for leftTree in allLeftTrees:
                for rightTree in allRightTrees:
                    root = TreeNode(val)
                    root.left = leftTree
                    root.right = rightTree
                    
                    allTrees.append(root)
                
        return allTrees
