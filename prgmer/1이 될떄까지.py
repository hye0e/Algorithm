n, k = map(int, input().split())

while True:
    n -= 1
    if n % k == 0:
        n = n//k
    
    if n == 1:
        break

print(n)