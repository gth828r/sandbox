public class Node<T extends Comparable<T>> {

  protected T data;
  protected Node<T> leftChild;
  protected Node<T> rightChild;

  public Node(T data) {
    this.data = data;
  }

  public void setLeftChild(Node<T> child) {
    this.leftChild = child;
  }

  public void setRightChild(Node<T> child) {
    this.rightChild = child;
  }

  public void setData(T data) {
    this.data = data;
  }

  public Node<T> getLeftChild() {
    return this.leftChild;
  }

  public Node<T> getRightChild() {
    return this.rightChild;
  }

  public T getData() {
    return this.data;
  }

  public boolean hasLeftChild() {
    return (this.leftChild != null);
  }

  public boolean hasRightChild() {
    return (this.rightChild != null);
  }

  public int compareTo(Node<T> other) {
    return this.data.compareTo(other.getData());
  }
}
