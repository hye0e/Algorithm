import sys

N, M = sys.stdin.readline().split()
N = int(N)
M = int(M)
print(M - N - 1)
if M - N <= 1:
    print(0)
else:
    for i in range(N + 1, M):
        print(i, end = ' ')
