"""
4 6
a t c i s w

반례
3 6
a e i c d z

"""
import sys

input = sys.stdin.readline

L, C = map(int, input().strip().split())
alphabet = sorted(input().split())

visited = [False for _ in range(C)]
aeiou_arr = ['a', 'e', 'i', 'o', 'u']
password = []

def aeiou_check(password):
    aeiou_count = 0
    rest_count = 0
    for p in password:
        if p in aeiou_arr:
            aeiou_count += 1
        else:
            rest_count += 1
    return [aeiou_count, rest_count]

def dfs(start, count):
    global alphabet
    aeiou_count, rest_count = aeiou_check(password)
    if len(password) == L and  aeiou_count > 0 and rest_count >= 2:
        print(''.join(password))
        return

    for i in range(start, C):
        if visited[i]:
            continue

        password.append(alphabet[i])
        visited[i] = True
        dfs(i, count + 1)
        visited[i] = False
        password.pop()

dfs(0, 0)

