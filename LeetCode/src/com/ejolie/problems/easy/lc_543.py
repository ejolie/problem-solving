from typing import Optional

from com.ejolie.problems.structure.TreeNode import TreeNode

"""
543. Diameter of Binary Tree
"""
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.diameter = 0
        
        def height(node: Optional[TreeNode]) -> int:
            if not node:
                return -1

            l_height = height(node.left)
            r_height = height(node.right)
            self.diameter = max(self.diameter, 2 + l_height + r_height)

            return 1 + max(l_height, r_height)
    
        height(root)
        
        return self.diameter

left = TreeNode(2, TreeNode(4), TreeNode(5))
right = TreeNode(3)
root = TreeNode(1, left, right)

solution = Solution()
assert solution.diameterOfBinaryTree(root) == 3