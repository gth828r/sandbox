import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class DirectedALGraph<Value> extends ALGraph<Value> {

  public DirectedALGraph() {
    this.isDirected = false;
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

  public void deleteVertex(Value value) {
    Vertex<Value> toDelete = vertexList.get(value);

    if (toDelete != null) {

      for (Vertex<Value> vertex : vertexList.values()) {
        if (vertex.isNeighbor(toDelete)) {
          this.deleteEdge(vertex.getValue(), toDelete.getValue());
        }
      }

      vertexList.remove(value);
    }
  }
}
