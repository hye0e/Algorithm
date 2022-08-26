N = int(input())
road_list = input().split()
x, y = 1, 1

for road in road_list:
    if road == "R":
        if x < N and x >= 1:
            x+=1
     
    if road == "L":
        if x <= N and x > 1:
            x-=1

    if road == "U":
        if y <= N and y > 1:
            y-=1

    if road == "D":
        if y < N and y >= 1:
            y+=1

print(y, x)