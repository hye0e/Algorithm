def min_times_all_served(n, serving_times):
    start = 0
    end = max(serving_times) * n
    sorted(serving_times)
    min_times = 0
    while start <= end:
        work = 0
        mid = (start + end) // 2
        for time in serving_times:
            work += mid // time 
        
        if work < n:
            start = mid + 1
        elif work >= n:
            end = mid - 1
            min_times = mid

    return min_times

def validation(work):
    return work
if __name__ == '__main__':
    print(min_times_all_served(2, [1, 2]))  # Should be 2
    print(min_times_all_served(3, [1, 99, 99])) # Should be 3
    print(min_times_all_served(6, [7, 10])) # Should be 28


        