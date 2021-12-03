def naturalMergeSort(arr):
    run_list = []
    run = [arr[0]]
    left = 1
    while True:
        if run[-1] <= arr[left]:
            run.append(arr[left])
        else:
            run_list.append(run)
            run = []
            run.append(arr[left])

        left += 1

        if left == len(arr):
            run_list.append(run)
            break
    return run_list  

def merge(arr, l, m, r):
    n1 = m - l + 1
    n2 = r - m
 
    L = []
    R = []
 
    for i in range(0, n1):
        L.extend(arr[l + i])
 
    for j in range(0, n2):
        R.extend(arr[m + 1 + j])
    
    print(arr)
def mergeSort(arr, left, mid, right):
    i = left
    j = mid + 1
    k = left

    result = arr[:]
    while i <= mid and j <= right:
        if arr[i] < arr[j]:
            result[k] = arr[i]
            k += 1
            i += 1
        else:
            result[k] = arr[j]
            k += 1
            j += 1
        

    if i > mid:
        for i in range(j, right + 1):
            result[k] = arr[i]
            k += 1
    else:
        for i in range(i, mid + 1):
            result[k] = arr[i]
            k += 1
    for i in range(1, right + 1):
        arr[i] = result[i]

if __name__ == '__main__':
    # arr = [6, 7, 8, 3, 4, 1, 5, 9, 10, 2]
    run_list = naturalMergeSort([6, 7, 8, 3, 4, 1, 5, 9, 10, 2])
    n = len(run_list)
    l = 0
    r = n - 1
    merge(run_list, 0, l+(r-l)//2, r)
   