def solution(s):
    answer = ''
    s = s.lower()
    s = list(s)
    s[0] = s[0].upper()
    for i in range(len(s) - 1):
        if s[i] == ' ':
            s[i + 1] = s[i +1].upper()
    
    return ''.join(s)

    return answer

print(solution("3people unFollowed me"))
