import java.util.HashMap;

public class ALGraph<Value> {

  HashMap<Value, Vertex<Value>> vertexList;    

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

}
