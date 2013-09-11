import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

public class Vertex<Value> {

  protected Value value;
  protected HashMap<Value, Edge<Value>> neighbors;

  public Vertex(Value value) {
    this.value = value;
    neighbors = new HashMap<Value, Edge<Value>>();
  }

  public void setValue(Value value) {
    this.value = value;
  }

  public Value getValue() {
    return this.value;
  }

  public void addNeighbor(Vertex<Value> v) {
    Edge<Value> e = new Edge<Value>(v);
    neighbors.put(v.getValue(), e);
  }

  public void addNeighbor(Vertex<Value> v, int weight) {
    Edge<Value> e = new Edge<Value>(v, weight);
    neighbors.put(v.getValue(), e);
  }

  public void deleteNeighbor(Vertex<Value> v) {
    neighbors.remove(v.getValue());
  }

  public boolean isNeighbor(Vertex<Value> v) {
    return neighbors.containsKey(v.getValue());
  }

  public Collection<Vertex<Value>> listNeighborVertices() {
    Collection<Vertex<Value>> neighborVertices = new ArrayList<Vertex<Value>>();
    for (Edge<Value> neighborEdge : neighbors.values()) {
      Vertex<Value> v = neighborEdge.getVertex();
      neighborVertices.add(v);
    }

    return neighborVertices;
  }

  public Collection<Edge<Value>> listNeighbors() {
    return neighbors.values();
  }

  public String toString() {
    return "<" + this.value + ">";
  }
}
