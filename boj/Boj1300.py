import sys

# n = int(sys.stdin.readline())

dp = [0] * 100
dp[0] = 0
dp[1] = 1 

def fibo(no):
    if no == 0: return 0
    if no == 1: return 1
    if dp[no] != 0:
        return dp[no]
    dp[no] = fibo[no - 1] + fibo[no - 2]

if __name__ == '__main__':
    print(fibo(2))

# one_cnt = 0
# zero_cnt = 0
# for i in range(n):
#     no = int(sys.stdin.readline())
#     if fibo(no) == 1:
#         one_cnt += 1
#     elif fibo(no) == 0:
#         zero_cnt += 1



