import sys

room = sys.stdin.readline()

num = {'1': 0, '2': 0, '3': 0, '4': 0, '5': 0, '6': 0, '7': 0, '8': 0}
for i in range(len(room)):
    if room[i] in ['6', '9']:
        num['6'] += 1
    else:
        num[num[i]] += 1

if num['6'] % 2 == 0:
    num['6'] = num['6'] // 2
else:
    num['6'] = num['6'] // 2 + 1

print(max(num.values))
