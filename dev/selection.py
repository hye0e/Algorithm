def selection(arr):
    min = arr[0]
    
    for i in range(len(arr) - 1):
        min_idx = i
        for j in range(i+1, len(arr)):
            if min > arr[i]:
                min = arr[i]
            arr[min_idx] = min