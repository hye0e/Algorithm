def solution(nums):
    count=len(nums)/2
    poketmon = []
    for i in nums:
        if poketmon.count(i) == 0:
            poketmon.append(i)

    print(poketmon)
    print(poketmon[:count])
    return len(poketmon[:count])

if __name__ == '__main__':
    print(solution([3,3,3,2,2,2]))