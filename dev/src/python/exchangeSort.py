# -*- coding: utf-8 -*-
def exchangeSort(arr):
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            if arr[i] > arr[j]:
                arr[i], arr[j] = arr[j], arr[i]

    return arr

def selectionSort(a, n):
    for i in range(1, n - 1):
        minIndex = i
        for j in range(i + 1, n + 1):
            if a[j] < a[minIndex]:
                minIndex = j
        a[minIndex], a[i] = a[i] , a[minIndex] 

    return a

def bubbleSort(a, n):
    for i in range(n, 1, -1):
        for j in range(i):
            if a[j] > a[j+1]:
                a[j], a[j+1] = a[j+1], a[j] 
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
arr1 = []
arr1.append(None)

for i in range(N):
    arr1.append(random.randint(1, N))

arr2 = arr1[:]
arr3 = arr1[:]

bubble_start_time = time.time()
arr1 = bubbleSort(arr1, N)  
bubble_end_time = time.time() - bubble_start_time

selection_start_time = time.time()
arr2 = selectionSort(arr2, N)
selection_end_time = time.time() - selection_start_time

exchange_start_time = time.time()
arr3 = exchangeSort(arr3)
exchange__end_time = time.time() - exchange_start_time

print("버블 정렬의 실행 시간 (N=%d) : %0.3f"%(N, bubble_end_time))
print("선택 정렬의 실행 시간 (N=%d) : %0.3f"%(N, selection_end_time))
print("교환 정렬의 실행 시간 (N=%d) : %0.3f"%(N, exchange__end_time))

checkSort(arr1, N)
checkSort(arr2, N)
checkSort(arr3, N)