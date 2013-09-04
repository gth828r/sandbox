import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public abstract class ALGraph<Value> extends Graph<Value> {

  private static final boolean DEBUG_ON = false;

  protected HashMap<Value, Vertex<Value>> vertexList;    

  public ALGraph() {
    this.vertexList = new HashMap<Value, Vertex<Value>>();
  }

  public ALGraph(boolean isDirected) {
    vertexList = new HashMap<Value, Vertex<Value>>();
  }

  public abstract void addEdge(Value value1, Value value2);

  public abstract void deleteEdge(Value value1, Value value2);

  public void addVertex(Value value) {
    Vertex<Value> v = new Vertex<Value>(value);
    vertexList.put(value, v);
  }

  public abstract void deleteVertex(Value value);

  public boolean contains(Value value) {
    return vertexList.containsKey(value);
  }

  public Vertex<Value> bfs(Value toFind, Value start) {
    Vertex<Value> startVertex = vertexList.get(start);
    HashMap<Value, Vertex<Value>> visited = new HashMap<Value, Vertex<Value>>();
    return bfs(toFind, startVertex, visited);
  }

  protected Vertex<Value> bfs(Value toFind, Vertex<Value> startVertex, HashMap<Value, Vertex<Value>> visited) {  
    Queue<Vertex<Value>> queue = new LinkedList<Vertex<Value>>();
    queue.add(startVertex);
    visited.put(startVertex.getValue(), startVertex);

    while (!queue.isEmpty()) {
      // remove next element from the queue
      Vertex<Value> probe = queue.remove();

      if (DEBUG_ON) {
        System.err.println(probe);
      }

      // if we find the vertex we want, just return it
      if (toFind.equals(probe.getValue())) {
        return probe;
      }

      for (Vertex<Value> vertex : probe.listNeighbors()) {
        if (!visited.containsKey(vertex.getValue())) {
          visited.put(vertex.getValue(), vertex);
          queue.add(vertex);
        }
      }
    }

    return null;
  }

  public Vertex<Value> dfs(Value toFind, Value start) {
    Vertex<Value> startVertex = vertexList.get(start);
    HashMap<Value, Vertex<Value>> visited = new HashMap<Value, Vertex<Value>>();
    visited.put(start, startVertex);
    return dfs(toFind, startVertex, visited);
  }

  protected Vertex<Value> dfs(Value toFind, Vertex<Value> probe, HashMap<Value, Vertex<Value>> visited) {  
    
    if (DEBUG_ON) {
      System.err.println(probe);
    }

    // if this is the value we are looking for, return it
    if (toFind.equals(probe.getValue())) {
      return probe;
    }

    for (Vertex<Value> vertex : probe.listNeighbors()) {
      if (!visited.containsKey(vertex.getValue())) {
        visited.put(vertex.getValue(), vertex);
        Vertex<Value> result = dfs(toFind, vertex, visited);
        if (result != null) {
          return result;
        } 
      }
    }

    return null;
  }

  public String toString() {
    StringBuilder graphStr = new StringBuilder();

    for (Vertex<Value> vertex : vertexList.values()) {
      graphStr.append(vertex.toString());
      graphStr.append(" -> ");
      
      for (Vertex<Value> neighbor : vertex.listNeighbors()) {
        graphStr.append(neighbor.toString());
        graphStr.append(", ");
      }

      graphStr.append("\n");
    }

    return graphStr.toString();
  }
}
