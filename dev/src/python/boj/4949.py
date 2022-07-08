while True:
    str = input()
    stack = []
    
    if str == '.':
        break

    flag = True
    for i in str:
        if i == '[' or i == '(':
            stack.append(i)

        elif i == ']':
            if not stack and stack[-1] == '[':
                stack.pop()
            else:
                flag = False
                break
        elif i == ')':
            if not stack and stack[-1] == '(':
                stack.pop()
            else:
                flag = False
                break
    
    if flag and not stack:
        print('yes')
    else:
        print('no')