def solution(nums):
    total_cnt = len(nums) // 2 
    answer = []

    num_dict = {}
    for num in nums:
        if num not in num_dict:
            num_dict[num] = 1
        else:
            num_dict[num] += 1
    
    for key in num_dict:
        if total_cnt == 0:
            break
        if num_dict[key] != 0 and key not in answer:
            answer.append(key)
            num_dict[key] -= 1
            total_cnt -= 1

    # min(len(ls)/2, len(set(ls)))       
    return len(answer)

print(solution([3, 1, 2, 3]))