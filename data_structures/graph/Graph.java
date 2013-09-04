public abstract class Graph<Value> {

  public abstract void addEdge(Value value1, Value value2);

  public abstract void deleteEdge(Value value1, Value value2);

  public abstract void addVertex(Value value);

  public abstract void deleteVertex(Value value);

  public abstract Vertex<Value> bfs(Value value, Value start);

  public abstract Vertex<Value> dfs(Value value, Value start);
}
