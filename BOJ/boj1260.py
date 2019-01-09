import queue

def dfs(graph, v):
    global visited
    global answer
    stack = []
    stack.append(v)
    while stack != []:
        w = stack.pop()
        if visited[w] == 0:
            visited[w] = 1
            answer += str(w) + ' '
        for i in range(len(graph)-1, -1, -1):
            if graph[w][i] == 1 and visited[i] == 0:
                stack.append(i)
        
def bfs(path, v):
    global visited
    global answer
    q = queue.Queue();
    q.put(v)
    while not q.empty():
        w = q.get()
        if visited[w] == 0:
            answer += str(w) + ' '
            visited[w] = 1
        for i in range(len(graph)):
            if graph[w][i] == 1 and visited[i] == 0:
                q.put(i)

n, m, v = map(int, input().split())
graph = [[0 for j in range(n+1)] for i in range(n+1)]

for i in range(int(m)):
    x, y = map(int, input().split())
    graph[x][y] = 1
    graph[y][x] = 1

answer = ''
visited = [0 for i in range(n+1)]
dfs(graph, v)
print(answer)
        
answer = ''
visited = [0 for i in range(n+1)]
bfs(graph, v)
print(answer)