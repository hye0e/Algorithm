list = [1, 2, 4, 5]
x = 3
index = 0
for i in list:
    # print(i)
    if i > x:
        print(index)
        list.insert(index, x)
        break
    else:
        index += 1     
print(list)
