import sys
cnt = int(sys.stdin.readline())

money = 0
t_list = []
p_list = []
for i in range(cnt):
   t, p = sys.stdin.readline().split()
   t_list.append(int(t))
   p_list.append(int(p))

money = p_list[0]
day = t_list[0]

while day < cnt:
    if day + t_list[day] > cnt:
        break
    money += p_list[day]
    day += t_list[day]

print(money)
