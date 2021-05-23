n = int(input())
inList=list(map(int, input().split()))

dp=[1 for _ in range(n)]
for i in range(1, n):
    for j in range(i):
        if inList[j] < inList[i]:
            print('dp[i] = ', dp[i])
            print('dp[j]+1 = ', dp[j]+1)
            dp[i] = max(dp[i], dp[j]+1)
            
    
print(max(dp))