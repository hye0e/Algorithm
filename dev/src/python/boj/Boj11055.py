n = int(input())
arr = list(map(int, input().split()))
dp = [1 for _ in range(n)]
dpArr=[arr[0]]
for i in range(1, n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j]+1)

print(dp)
print(dpArr)
print(set(dpArr))