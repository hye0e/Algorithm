DAY = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
MONTH = [0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
mon, day = map(int, input().split())

sum = 0
for i in range(0, mon):
    sum += MONTH[i]
sum += day
print(DAY[sum%7])