def fibo(n):
    dp = [0] * (n+1)

    dp[0] = 1
    dp[1] = 1
    for i in range(2, len(dp)):
        dp[i] = dp[i-1]+dp[i-2]

    print(dp[n]%10007)

if __name__ == '__main__':
    n = int(input())
    
    fibo(n)
    