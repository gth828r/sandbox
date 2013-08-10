public class Tree<T extends Comparable<T>> {

  protected Node<T> root;

  private void addNode(T data, Node<T> curNode) {
    Node<T> wrapperNode = new Node<T>(data);

    if (wrapperNode.compareTo(curNode) <= 0) {
      if (curNode.hasLeftChild()) {
        this.addNode(data, curNode.getLeftChild());
      } else {
        curNode.setLeftChild(new Node<T>(data));
      }
    } else {
      if (curNode.hasRightChild()) {
        this.addNode(data, curNode.getRightChild());
      } else {
        curNode.setRightChild(new Node<T>(data));
      }
    }
  }

  public void addNode(T data) {
    if (root == null) {
      root = new Node<T>(data);
    } else {
      this.addNode(data, root);
    }
  }

  private Node<T> removeRightmostNode(Node<T> curNode, Node<T> parent, Node<T> toRemove) {
    if (curNode.hasRightChild()) {
      return removeRightmostNode(curNode.getRightChild(), curNode, toRemove);
    } else {
      if (toRemove.compareTo(parent) != 0)
        parent.setRightChild(curNode.getLeftChild());

      return curNode;
    }
  }

  private Node<T> removeLeftmostNode(Node<T> curNode, Node<T> parent, Node<T> toRemove) {
    if (curNode.hasLeftChild()) {
      return removeLeftmostNode(curNode.getLeftChild(), curNode, toRemove);
    } else {
      if (toRemove.compareTo(parent) != 0)
        parent.setLeftChild(curNode.getRightChild());

      return curNode;
    }
  }

  private T removeNode(T data, Node<T> curNode, Node<T> parent) {
    Node<T> wrapperNode = new Node<T>(data);

    if (wrapperNode.compareTo(curNode) == 0) {
      //remove current node
      Node<T> toRemove = curNode;
      Node<T> replacement = null;

      if (toRemove.getRightChild() != null) 
        System.out.println(toRemove.getRightChild().getData());

      if (toRemove.hasLeftChild()) {
        //make right-most node in left subtree new parent
        replacement = this.removeRightmostNode(curNode.getLeftChild(), curNode, toRemove);

        if (toRemove.getRightChild() != null) 
          System.out.println(toRemove.getRightChild().getData());

        replacement.setRightChild(toRemove.getRightChild());

        if (replacement.compareTo(toRemove.getLeftChild()) != 0) {
          replacement.setLeftChild(toRemove.getLeftChild());
        } else {
          parent = null;
        }

        System.out.println(replacement.getLeftChild().getData() + "--" + replacement.getData() + "--" + replacement.getRightChild().getData());

      } else if (curNode.hasRightChild()) {
        //make left-most node in right subtree new parent
        replacement = this.removeLeftmostNode(curNode.getRightChild(), curNode, toRemove);
        replacement.setLeftChild(toRemove.getLeftChild());
        
        if (replacement.compareTo(toRemove.getRightChild()) != 0) {
          replacement.setRightChild(toRemove.getRightChild());
        } else {
          parent = null;
        }

        System.out.println(replacement.getLeftChild().getData() + "--" + replacement.getData() + "--" + replacement.getRightChild().getData());
      }

      if (parent != null) {
        if (parent.getLeftChild() != null && toRemove.compareTo(parent.getLeftChild()) == 0) {
          parent.setLeftChild(replacement);
        } else {
          parent.setRightChild(replacement);
        }
      } else {
        // if the parent is null, then the node is the root of the tree
        root = replacement;
      }

      return toRemove.getData();

    } else if (wrapperNode.compareTo(curNode) < 0) {
      //check left child
      if (curNode.hasLeftChild()) {
        return removeNode(data, curNode.getLeftChild(), curNode);
      } else {
        return null;
      }
    } else {
      //check right child
      if (curNode.hasRightChild()) {
        return removeNode(data, curNode.getRightChild(), curNode);
      } else {
        return null;
      }
    }
  }

  public T removeNode(T data) {
    if (root == null) {
      return null;
    } else {
      return this.removeNode(data, root, null);
    }
  }

  public String toString() {
    
    StringBuilder treeStr = new StringBuilder();
    addToTreeString(root, treeStr, 0);

    return treeStr.toString();
   }

   private void addToTreeString(Node<T> curNode, StringBuilder treeStr, int depth) {

     if (curNode != null) {
       treeStr.append('\n');
       for (int i = 0; i < depth; i++) {
         treeStr.append(' ');
       }
       treeStr.append("+ ");
       treeStr.append(curNode.getData().toString());

       if (curNode.hasLeftChild()) {
         addToTreeString(curNode.getLeftChild(), treeStr, depth + 1);
       }

       if (curNode.hasRightChild()) {
         addToTreeString(curNode.getRightChild(), treeStr, depth + 1);
       }
     }
   }
}
