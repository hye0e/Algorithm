    def productExceptSelf(self, nums):
        index = 0
        output = []
        sum = 1
        for i in range(len(nums)):
            if i == index:
                sum = 1
                continue
            sum *= nums[i]
            index += 1
            
            output.append(sum)
            
        return output