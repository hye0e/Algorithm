# -*- coding: utf-8 -*-
def makeRunList(arr):
    run_list = []
    run = [arr[1]]
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

def merge(a, b):
    i, j = 0, 0
    m = []
    n1 = len(a)
    n2 = len(b)
    while i < n1 and j < n2:
        if a[i] < b[j]:
            m.append(a[i])
            i += 1
        else:
            m.append(b[j])
            j += 1
    if i==n1:
        for k in range(j, n2):
            m.append(b[k])
    else:
        for k in range(i, n1):
            m.append(a[k])
    return m

def naturalMergeSort(run_list, n):
    while n > 1:
        i = 0
        temp_arr = []
        while i < n:
            if i == n-1:
                temp_arr.append(run_list[i])
                break
            else:
                temp_arr.append(merge(run_list[i], run_list[i+1]))
                i += 2
        n = len(temp_arr)
        run_list = temp_arr
    return run_list[0]

def mergeSort(a, l, r): 
    if r > l:
        m = int((l+r)/2) 
        mergeSort(a, l, m) 
        mergeSort(a, m+1, r)
        i, j, k = l, m+1, l
        while i <= m and j <= r:
            if a[i] < a[j]: 
                b[k] = a[i]
                k += 1
                i += 1 
            else:
                b[k] = a[j] 
                k += 1
                j += 1
        if i > m:
            for p in range(j, r+1):
                b[k] = a[p]
                k += 1 
        else:
            for p in range(i, m+1): 
                b[k] = a[p]
                k += 1
        for p in range(l, r+1):
            a[p] = b[p]

    return a

def checkSort(a, n):
    isSorted = True
    for i in range(1, n):
        if a[i] > a[i+1]:
            isSorted = False
        if not isSorted:
            break
    if isSorted:
        print("정렬 완료")
    else:
        print("정렬 오류 발생")

import random, time

N = 5000
a = []
a.append(None)

for i in range(N):
    a.append(random.randint(1, N))

b = a[:]
arr = a[:]
merge_start_time = time.time()
mergeSort(a, 1, N)  
merge_end_time = time.time() - merge_start_time
print("합병 정렬의 실행 시간 (N=%d) : %0.3f"%(N, merge_end_time))
checkSort(a, N)

naturalMerge_start_time = time.time()
run_list = makeRunList(arr)
arr = naturalMergeSort(run_list, len(run_list))
naturalMerge_end_time = time.time() - naturalMerge_start_time
print("자연 합병 정렬의 실행 시간 (N=%d) : %0.3f"%(N, naturalMerge_end_time))

checkSort(arr, N)

   