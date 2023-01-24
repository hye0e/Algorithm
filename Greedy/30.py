import sys

N = sys.stdin.readline().strip()
num = sorted(list(map(int, N)), reverse= True)
num = int(''.join(map(str, num)))

if str(num)[-1] != '0':
    print(-1)
elif num % 30 != 0:
    print(-1)
else:
    answer = num // 30
    print(30 * answer)