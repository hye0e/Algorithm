def selection_sort(arr):
    for i in range(len(arr) - 1):
        min_idx = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[min_idx]:
                min_idx = j
        arr[i], arr[min_idx] = arr[min_idx], arr[i]

    return arr

num_list = []
cnt = int(input())
for i in range(0, cnt):
    num = input()
    num_list.append(num)

num_list = selection_sort(num_list)
for number in num_list:
    print(number)


    