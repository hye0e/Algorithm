## 힙 (heapq)

- 완전 이진 트리의 일종으로 **우선순위 큐**를 위하여 만들어진 자료구조
    - 우선순위 큐? 우선순위의 개념을 큐에 도입한 자료구조
    - 우선순위 큐는 배열, 연결리스트, 힙으로 구현 가능하다. 이 중 힙으로 구현하는 것이 가장 효율적이다.
    <img width="652" alt="image" src="https://user-images.githubusercontent.com/46226445/192334895-33f37b2c-a77c-4ba1-9399-cd85bed5507d.png">
- 특정한 규칙을 가지는 트리로 최댓값과 최솟값을 찾는 연산을 빠르게 하기 위해 고안된 것
- 힙의 종류
    - 최대 힙(max heap)
        - 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진 트리
    - 최소 힙(min heap)
        - 부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진 트리
    - <img width="723" alt="image" src="https://user-images.githubusercontent.com/46226445/192334963-531fc73a-2ef6-4b9a-906d-c963c1c9c7a0.png">
- 힙 함수 활용하기
    - heapq.heappush(heap, item): item을 heap에 추가
    - heapq.heappop(heap): heap에서 **가장 작은 원소**를 pop하고 리턴
    주의! 값이 비어있는 경우 IndexError 가 호출된다.
    - heapq.heapify(x): 리스트 x를 즉각적으로 heap으로 변환함
- 힙 생성
    
    ```python
    import heapq
    
    heap = []
    heapq.heappush(heap, 10)
    heapq.heappush(heap, 20)
    heapq.heappush(heap, 30)
    ```
    
- 힙에서 원소 삭제
    
    ```python
    result = heapq.heappop(heap)
    
    print(result)
    >> 10
    print(heap)
    >> [20, 30]
    ```
    
- 최대 힙 만들기
    - 파이썬의 heapq 모듈은 **최소 힙**으로 구현되어 있기 때문에 최대 힙 구현을 위해서는 트릭이 필요하다
    - 힙에 원소를 추가 할 때 (-item, item)의 튜플 형태로 넣어주기
    <br>
    원소의 부호를 바꿨기 때문에, 최대 힙으로 구현 가능하다.
    <br>
    ex) 3, 5, 7, 9 → -3, -5, -7, -9
    <br>
    순서 정렬 → -9, -7, -5, -3 최대 힙으로 구현 가능
- 구현 코드
    
    ```python
    heap_item = [1, 3, 5, 7, 9]
    
    max_heap = []
    for item in heap_items:
    	heapq.heappush(max_heap, (-item, item))
    
    print(max_heap)
    
    # 실제 원소 값은 튜플의 두 번째 자리에 저장되어있으므로 
    # [1] 인덱싱을 통해 접근
    max_item = heapq.heappop(max_heap)[1]
    print(max_item)
    ```
