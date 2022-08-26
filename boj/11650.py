import sys

input = sys.stdin.readline
N = int(input())
nums = [] 
for i in range(N): 
    [a, b] = map(int, input().split()) 
    nums.append([a, b]) 
    
nums = sorted(nums) 
for i in range(N): 
    print(nums[i][0], nums[i][1])


# xy_list = ['*'] * (N+1)

# for i in range(N):
#     x, y = map(int, sys.stdin.readline().split())
#     if xy_list[x] != '*':
#         xy_list[x].append(y)

#     else:
#         xy_list[x] = [y]

# for i in range(len(xy_list)):
#     if xy_list[i] != '*':
#         xy_list[i] = sorted(xy_list[i])

#         for j in range(len(xy_list[i])):
#             print(i, xy_list[i][j])
