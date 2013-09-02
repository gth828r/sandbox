public abstract class Graph<Value> {

  public abstract void addEdge(Vertex<Value> v1, Vertex<Value> v2);

  public abstract void deleteEdge(Vertex<Value> v1, Vertex<Value> v2);

  public abstract void addVertex(Value value);

  public abstract void deleteVertex(Value value);
}
