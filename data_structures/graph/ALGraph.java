import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class ALGraph<Value> {

  protected HashMap<Value, Vertex<Value>> vertexList;    

  public ALGraph() {
    vertexList = new HashMap<Value, Vertex<Value>>();
  }

  public void addEdge(Value value1, Value value2) {
    Vertex<Value> v1 = vertexList.get(value1);
    Vertex<Value> v2 = vertexList.get(value2);
   
    if (v1 != null && v2 != null) {
      v1.addNeighbor(v2);
    }
  }

  public void deleteEdge(Value value1, Value value2) {
    Vertex<Value> v1 = vertexList.get(value1);
    Vertex<Value> v2 = vertexList.get(value2);
   
    if (v1 != null && v2 != null) {
      v1.deleteNeighbor(v2);
    }
  }

  public void addVertex(Value value) {
    Vertex<Value> v = new Vertex<Value>(value);
    vertexList.put(value, v);
  }

  public void deleteVertex(Value value) {
    Vertex<Value> toDelete = vertexList.get(value);

    if (toDelete != null) {

      for (Vertex<Value> vertex : vertexList.values()) {
        if (vertex.isNeighbor(toDelete)) {
          vertex.deleteNeighbor(toDelete);
        }
      }

      vertexList.remove(value);
    }
  }

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
}
