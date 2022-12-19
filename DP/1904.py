import sys

N = int(sys.stdin.readline())
dp = [0] * (N + 1)

dp[1] = 1 # 1
dp[2] = 2 # 00 11
# 3 = 001 100 111 -> dp[1] + dp[2] = 3
# 4 = 0011 1100 1001 0000 1111 -> dp[2] + dp[3]

# 메모리 초과 -> 이 코드의 점화식은 n번째 항의 자릿수가 O(n)이기 때문에 n개의 수를 모두 개별적으로 저장하면 필요한 메모리는 O(n^2)이 됩니다. ??
for i in range(3, N + 1):
    dp[i] = (dp[i - 2] + dp[i - 1]) % 15746

print(dp[N])