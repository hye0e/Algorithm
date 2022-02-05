# -*- coding: utf-8 -*-
def cocktailShakerSort(arr2):
    maxFlag = True
    swapFlag = True
    right = len(arr2) - 1
    left = 0
    
    while swapFlag:
        swapFlag = False

        if maxFlag:
            for i in range(left, right):
                if arr2[i] > arr2[i + 1]:
                    arr2[i], arr2[i + 1] = arr2[i + 1], arr2[i]
                    swapFlag = True

            right -= 1
            maxFlag = False

        else:
            for i in range(right - 1, left - 1, -1):
                if arr2[i] > arr2[i + 1]:
                    arr2[i], arr2[i + 1] = arr2[i + 1], arr2[i]
                    swapFlag = True
            
            left += 1
            maxFlag = True

def checkSort(a, n):
    isSorted = True
    for i in range(1, n - 1):
        if a[i] > a[i + 1]:
            isSorted = False
        if not isSorted:
            break
    if isSorted:
        print("정렬 완료")
    else:
        print("정렬 오류 발생")

def bubbleSort(a, n):
    print(n)
    for i in range(n-1, 0, -1):
        for j in range(i):
            if a[j] > a[j+1]:
                a[j], a[j+1] = a[j+1], a[j] 

import random, time

N = 5000
arr1 = []
for i in range(N):
    arr1.append(random.randint(1, N))
arr2 = arr1[:]

bubble_start_time = time.time()
bubbleSort(arr1, N)
bubble_end_time = time.time() - bubble_start_time


cocktail_start_time = time.time()
cocktailShakerSort(arr2)
cocktail__end_time = time.time() - cocktail_start_time

print("버블 정렬의 실행 시간 (N=%d) : %0.3f"%(N, bubble_end_time))
print("칵테일 정렬의 실행 시간 (N=%d) : %0.3f"%(N, cocktail__end_time))

checkSort(arr1, N)
checkSort(arr2, N)
