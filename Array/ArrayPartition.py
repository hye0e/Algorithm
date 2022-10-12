from itertools import combinations

def arrayPairSum(nums):
    nums.sort()
    sum = 0

    for i in range(len(nums)):
        if i % 2 == 0:
            sum += nums[i]
    return sum
arrayPairSum([1,4,3,2])