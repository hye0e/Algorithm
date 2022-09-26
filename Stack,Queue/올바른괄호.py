from collections import deque

def solution(s):
    s = deque(s)
    answer = True
    stack = []

    if s[0] == ')': return False

    while s:
        v = s.popleft()
        if v == '(':
            stack.append(v)
        elif v == ')' and stack and stack[-1] == '(':
            stack.pop()
        else:
            answer = False
    
    answer = False if stack else answer
    
    return answer

print(solution('(()('))