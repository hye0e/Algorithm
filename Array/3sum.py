def threeSum(nums):
    output = []
    nums.sort()
    nums = set(nums)
    for i in range(len(nums)):
        for j in range(i + 1, len(nums)):
            for k in range(j + 1, len(nums)):
                if nums[i] + nums[j] + nums[k] == 0 and [nums[i], nums[j], nums[k]] not in output:
                    output.append([nums[i], nums[j], nums[k]])

    print(output)