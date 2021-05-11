n = int(input())
star = ' *'
for i in range(n-1, 0, -1):
    print(' '*i + '*' + star*((n-1)-i))
print('*'*((n*2)-1))