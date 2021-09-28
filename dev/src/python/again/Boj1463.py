num = int(input())
cnt = 0

while True:
    if num % 3 == 1:
        cnt += 2
        num -= 1
        num //= 3
    elif num % 3 == 0:
        cnt += 1
        num //= 3
    elif num % 2 == 0:
        cnt += 1
        num //= 2

    if num == 1: break

print(cnt)