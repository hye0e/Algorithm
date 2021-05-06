cnt = int(input())
for i in range(1, cnt+1, 1):
    A, B = map(int, input().split(','))
    print('Case #%d: %d'%(i, A+B))
    # print(f'Case #{i+1}: {A+B}')