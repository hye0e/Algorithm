INF = 10000

graph = {
    'A' : {'B':10,'C':3},
    'B' : {'C':1,'D':2},
    'C' : {'B':4,'D':8,'E':2},
    'D' : {'E':7},
    'E' : {'D':9}
}

start = 'A'

distance = {
    'A': INF,
    'B': INF,
    'C': INF,
    'D': INF,
    'E': INF
}

visited = {
    'A': False,
    'B': False,
    'C': False,
    'D': False,
    'E': False
}

store = []

distance[start] = 0

a_connected = graph[start]
visited['A'] = True
for key, value in a_connected.items():
    if distance[key] > value:
        distance[key] = value
    if visited[key] == False:
        store.append(key)

print(distance)
print(store)
min = INF
for store_item in store:
    if min > distance[store_item]:
        min = distance[store_item]
        min_vertex = store_item
print(min_vertex)
store.remove(min_vertex)
# 'C' : {'B':4,'D':8,'E':2},
visited[min_vertex] = True
min_vertex_connected = graph[min_vertex]
for key, value in min_vertex_connected.items():
    if distance[key] > distance[min_vertex] + value:
        distance[key] = distance[min_vertex] + value
    if (visited[key] == False) and (key not in store):
        store.append(key)

print(distance)
print(store)
if len(store) != 0:
    min = INF
    for store_item in store:
        if min > distance[store_item]:
            min = distance[store_item]
            min_vertex = store_item
    print(min_vertex)
    store.remove(min_vertex)
    # 'C' : {'B':4,'D':8,'E':2},
    visited[min_vertex] = True
    min_vertex_connected = graph[min_vertex]
    for key, value in min_vertex_connected.items():
        if distance[key] > distance[min_vertex] + value:
            distance[key] = distance[min_vertex] + value
        if (visited[key] == False) and (key not in store):
            store.append(key)

    print(distance)
    print(store)
if len(store) != 0:
    min = INF
    for store_item in store:
        if min > distance[store_item]:
            min = distance[store_item]
            min_vertex = store_item
    print(min_vertex)
    store.remove(min_vertex)
    # 'C' : {'B':4,'D':8,'E':2},
    visited[min_vertex] = True
    min_vertex_connected = graph[min_vertex]
    for key, value in min_vertex_connected.items():
        if distance[key] > distance[min_vertex] + value:
            distance[key] = distance[min_vertex] + value
        if (visited[key] == False) and (key not in store):
            store.append(key)

    print(distance)
    print(store)

if len(store) != 0:
    min = INF
    for store_item in store:
        if min > distance[store_item]:
            min = distance[store_item]
            min_vertex = store_item
    print(min_vertex)
    store.remove(min_vertex)
    # 'C' : {'B':4,'D':8,'E':2},
    visited[min_vertex] = True
    min_vertex_connected = graph[min_vertex]
    for key, value in min_vertex_connected.items():
        if distance[key] > distance[min_vertex] + value:
            distance[key] = distance[min_vertex] + value
        if (visited[key] == False) and (key not in store):
            store.append(key)

    print(distance)
    print(store)

if len(store) != 0:
    min = INF
    for store_item in store:
        if min > distance[store_item]:
            min = distance[store_item]
            min_vertex = store_item
    print(min_vertex)
    store.remove(min_vertex)
    # 'C' : {'B':4,'D':8,'E':2},
    visited[min_vertex] = True
    min_vertex_connected = graph[min_vertex]
    for key, value in min_vertex_connected.items():
        if distance[key] > distance[min_vertex] + value:
            distance[key] = distance[min_vertex] + value
        if (visited[key] == False) and (key not in store):
            store.append(key)

    print(distance)
    print(store)



print('end')