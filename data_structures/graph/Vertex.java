import java.util.HashMap;
import java.util.Collection;

public class Vertex<Value> {

  protected Value value;
  protected HashMap<Value, Vertex<Value>> neighbors;

  public Vertex(Value value) {
    this.value = value;
    neighbors = new HashMap<Value, Vertex<Value>>();
  }

  public void setValue(Value value) {
    this.value = value;
  }

  public Value getValue() {
    return this.value;
  }

  public void addNeighbor(Vertex<Value> v) {
    neighbors.put(v.getValue(), v);
  }

  public void deleteNeighbor(Vertex<Value> v) {
    neighbors.remove(v.getValue());
  }

  public boolean isNeighbor(Vertex<Value> v) {
    return neighbors.containsKey(v.getValue());
  }

  public Collection<Vertex<Value>> listNeighbors() {
    return neighbors.values();
  }

  public String toString() {
    return "<" + this.value + ">";
  }
}
