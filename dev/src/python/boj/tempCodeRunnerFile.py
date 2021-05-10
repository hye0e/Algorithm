n = int(input())
for i in (range(1, n+1)):
    print('*' * i + ' '*(2*4-(2*(i-1))) + '*' * i)

for i in (range(n-1, 0, -1)):
    print('*' * i + ' '*(2*4-(2*(i-1))) + '*' * i)