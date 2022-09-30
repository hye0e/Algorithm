def solution(brown, yellow):
    answer = []
    total = brown + yellow
    # 조건
    # 1. width >= length
    # 2. 2 * width + 2 * length - 4 = brown
    # 3. (width - 2) * (length - 2) = yellow
    for i in range(1, total + 1): 
        if total % i == 0:
            length = i
            width = int(total / length)
            if width >= length and ((2 * width) + (2 * length)) - 4 == brown and (width - 2) + (length - 2) == yellow:
                print(length)
                print(width)
                return [width, length]
    
    return answer