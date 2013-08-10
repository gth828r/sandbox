public class Test {

  public static void main(String args[]) {
    Tree<Integer> myTree = new Tree<Integer>();

    myTree.addNode(new Integer(5));
    myTree.addNode(new Integer(3));
    myTree.addNode(new Integer(7));
    myTree.addNode(new Integer(6));
    myTree.addNode(new Integer(8));
    myTree.addNode(new Integer(1));
    myTree.addNode(new Integer(2));
    myTree.addNode(new Integer(4));

    System.out.println(myTree.toString());

    myTree.removeNode(new Integer(5));
    System.out.println(myTree.toString());

    myTree.removeNode(new Integer(8));
    System.out.println(myTree.toString());

    myTree.removeNode(new Integer(4));
    System.out.println(myTree.toString());
  }
}
