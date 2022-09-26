## 스택/큐
<img width="531" alt="image" src="https://user-images.githubusercontent.com/46226445/192333968-8d41f5e4-5901-4111-8e56-d084c5d3a20e.png">

- 스택
    - 나중에 넣은 데이터가 먼저 반환되도록 설계한 메모리 구조
    - Last In First Out(LIFO)
    - 시간복잡도
        - 삽입, 삭제 시 O(1)
        - 검색 시 O(n)
    - 데이터 입력: push 데이터 출력: pop
    - pop으로 뽑아낸 데이터는 원래 리스트내에서 사라짐
    
    ```python
    list = [1, 2, 3, 4, 5]
    list.append(6)
    >>> list
    [1, 2, 3, 4, 5, 6]
    list.pop()
    >>> list
    [1, 2, 3, 4, 5]
    ```
    
- 큐
    - 먼저 줄 선 데이터가 먼저 반환되는 구조
    - First In First Out(FIFO)
    - 시간복잡도
        - 삽입, 삭제 시 O(1)
        - 검색 시 O(n)
    - 데이터 입력: push 데이터 출력: pop

    ```python
    from collections import deque

    queue = deque([1, 2, 3, 4, 5])

    # 삽입
    queue.append(6)
    >>> list
    [1, 2, 3, 4, 5, 6]
    # 삭제
    queue.popleft()
    >>> list
    [2, 3, 4, 5, 6]
    ```
