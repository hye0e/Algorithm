def solution(s):
    answer = 0
    temp = s

    for i in range(len(s)):
        flag = False
        temp = s[i:] + s[:i]
        stack = []
        for idx, t in enumerate(temp):
            if idx == 0 and (t == '}' or t == ')' or t == ']'):
                flag = True

            if t == '[' or t == '(' or t == '{':
                stack.append(t)

            if stack:
                if stack[-1] == '{' and t == '}':
                    stack.pop()
                elif stack[-1] == '(' and t == ')':
                    stack.pop()
                elif stack[-1] == '[' and t == ']':
                    stack.pop()
        if not stack and not flag:
            answer += 1

    return answer