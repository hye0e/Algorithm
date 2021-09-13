import sys
num = int(sys.stdin.readline())
print(num)
dp = [] * num
print(dp)
dp[1] = 1
dp[2] = 3
for i in range(3, num+1):
    dp[i] = dp[i-2] + dp[i - 1]

print(dp[num])