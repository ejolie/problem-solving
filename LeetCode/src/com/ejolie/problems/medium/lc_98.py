from typing import Optional
from com.ejolie.problems.structure.TreeNode import TreeNode

"""
98. Validate Binary Search Tree
"""
class Solution:
    def isValidBST_iterative(self, root: Optional[TreeNode]) -> bool:
        stack = []
        curr = root
        prev_val = -2**31-1
        
        while curr or stack:
            while curr:
                stack.append(curr)
                curr = curr.left
                
            curr = stack.pop()
            if curr.val <= prev_val:
                return False
            
            prev_val = curr.val
            curr = curr.right
        
        return True

    def isValidBST_recursive(self, root: Optional[TreeNode]) -> bool:
        return self._validate(root, float('-inf'), float('inf'))
        
    def _validate(self, node: Optional[TreeNode], lower: float, upper: float) -> bool:
        if not node:
            return True
        
        if not lower < node.val < upper:
            return False
            
        return self._validate(node.left, lower, node.val) and \
               self._validate(node.right, node.val, upper)
