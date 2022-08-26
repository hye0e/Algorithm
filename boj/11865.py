N, K = map(int, input().split())
stack = [i for i in range(1, N + 1)]
result = []
s = 0
print('<', end = '')
while stack:
    s += K - 1
    if s > len(stack):
        s %= len(stack)
    print(stack[s])
    stack.pop(s)
    if stack:
        print(', ', end='')
print('>')
