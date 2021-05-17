import sys
N = int(input()) 
nums = [1] * 10 
print(nums)
mod = 10007 
for _ in range(N-1): 
    for i in range(1, 10): 
        nums[i] = (nums[i] + nums[i-1])
print(str(sum(nums) % mod))