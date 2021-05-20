cnt = int(input())
l = []
for i in range(0, cnt):
    k = int(input())
    l.append(k)

l[0]+=l[1]
l[1]+=l[2]
for j in range(2, len(l)):
    l[j]+=max(l[j-1], l[j-2])

