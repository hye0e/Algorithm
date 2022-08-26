def isPrime(num):
    for i in range(2, num):
        if num % i == 0:
            return False
    return True

def solution(left, right):
    answer = 0
    cnt_list = []
    for i in range(left, right + 1):
        count = 1
        if isPrime(i):
            count += 1
            cnt_list.append(count)


        
        # if count % 2 == 0:
        #     answer += count
        # else:
        #     answer += count * (-1)
    return answer

if __name__ == '__main__':
    print(solution(13, 17))