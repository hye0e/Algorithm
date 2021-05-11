n = int(input())
star = [' ', '*']
for i in range(n-1, -1, -1):
    print(' '*i + '*'*1 + ''.join(star*((n-1)-i)))