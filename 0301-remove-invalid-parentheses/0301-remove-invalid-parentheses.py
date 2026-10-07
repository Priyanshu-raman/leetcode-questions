from collections import deque

class Solution:
    def removeInvalidParentheses(self, s: str) -> list[str]:
        def isValid(string: str) -> bool:
            count = 0
            for char in string:
                if char == '(':
                    count += 1
                elif char == ')':
                    count -= 1
                    if count < 0:
                        return False
            return count == 0

        result = []
        visited = {s}
        queue = deque([s])
        found = False

        while queue:
            curr = queue.popleft()

            if isValid(curr):
                result.append(curr)
                found = True

            # If we've already found valid strings at this level, 
            # don't generate the next level of removals.
            if found:
                continue

            for i in range(len(curr)):
                # Only attempt to remove parentheses, leave letters intact
                if curr[i] not in ('(', ')'):
                    continue
                
                # Generate child string by removing character at index i
                next_str = curr[:i] + curr[i+1:]
                
                if next_str not in visited:
                    visited.add(next_str)
                    queue.append(next_str)

        return result