n = int(input())
nums = [1] * n
if n == 1 or n == 2:
    print(1)
else:
    for i in range(2, n):
        nums[i] = nums[i-1] + nums[i-2]

    print(nums[n-1])