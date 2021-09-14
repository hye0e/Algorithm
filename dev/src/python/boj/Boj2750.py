def selectionSort(a, n):
    for i in range(n):
        minIndex = i
        for j in range(i, n):
            if a[j] < a[minIndex]:
                minIndex = j
            a[minIndex], a[i] = a[i], a[minIndex]
    return a

num_list = []
cnt = int(input())
for i in range(0, cnt):
    num = input()
    num_list.append(num)

num_list = selectionSort(num_list, len(num_list))
for number in num_list:
    print(number)


    