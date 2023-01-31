import sys


N = list(sys.stdin.readline().strip())
stack = [N[0]]
for i in range(1, len(N)):
    if N[i - 1] != N[i]:
        stack.append(N[i])


zero_count = stack.count('0')
one_count = stack.count('1')

print(min(zero_count, one_count))