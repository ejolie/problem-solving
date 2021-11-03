
from collections import deque
from typing import Optional

from com.ejolie.problems.structure.TreeNode import TreeNode

"""
129. Sum Root to Leaf Numbers
"""
class Solution:
    def sumNumbers_dfs_recursive(self, root: Optional[TreeNode]) -> int:
        self.result = 0
        self.dfs(root, 0)
        return self.result
    
    def dfs(self, root: Optional[TreeNode], path: int) -> None:
        if root:
            if not root.left and not root.right:
                path = path * 10 + root.val
                self.result += path
            
            self.dfs(root.left, path * 10 + root.val)
            self.dfs(root.right, path * 10 + root.val)

    def sumNumbers_dfs_iterative(self, root: Optional[TreeNode]) -> int:
        result = 0
        stack = deque()
        if root:
            stack.append(root)
        
        while stack:
            node = stack.pop()
            if not node.left and not node.right:
                result += node.val

            if node.left:
                node.left.val += node.val * 10
                stack.append(node.left)
            if node.right:
                node.right.val += node.val * 10
                stack.append(node.right)

        return result
    
    def sumNumbers_bfs(self, root: Optional[TreeNode]) -> int:
        result = 0
        queue = deque()
        if root:
            queue.append(root)

        while queue:
            node = queue.popleft()
            if not node.left and not node.right:
                result += node.val

            if node.left:
                node.left.val += node.val * 10
                queue.append(node.left)
            if node.right:
                node.right.val += node.val * 10
                queue.append(node.right)

        return result
