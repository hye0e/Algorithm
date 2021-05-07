DAY = ['SUN', 'MON', 'TUE', 'WED', 'TUR', 'FRI', 'SAT']
MONTH = [0, 31, 28, 31, 30, 31, 39, 31, 31, 30, 31, 30, 31]
mon, day = map(int, input().split())

sum = 0
for i in range(0, mon):
    print(i)
    sum += MONTH[i]
print(sum)
sum += day
print(DAY[sum%7])