public class Edge<Value> {
  
  private int weight;
  private Vertex<Value> vertex;

  public Edge(Vertex<Value> v) {
    this.weight = 1;
    this.vertex = v;
  }

  public Edge(Vertex<Value> v, int weight) {
    this.weight = weight;
    this.vertex = v;
  }

  public Vertex<Value> getVertex() {
    return this.vertex;
  }

  public int getWeight() {
    return this.weight;
  }

  public String toString() {
    return "-(" + weight + ")->";
  }
}
