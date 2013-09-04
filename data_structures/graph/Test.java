public class Test {

  public static void main(String args[]) {
    Graph<Integer> myGraph = new UndirectedALGraph<Integer>();

    myGraph.addVertex(1);
    myGraph.addVertex(2);
    myGraph.addVertex(3);
    myGraph.addVertex(4);
    myGraph.addVertex(5);
    myGraph.addVertex(6);
    myGraph.addVertex(7);
    myGraph.addVertex(8);
    myGraph.addVertex(9);
    myGraph.addVertex(10);
    myGraph.addVertex(11);

    myGraph.addEdge(1, 2);
    myGraph.addEdge(1, 3);
    myGraph.addEdge(1, 4);
    myGraph.addEdge(2, 5);
    myGraph.addEdge(3, 5);
    myGraph.addEdge(5, 6);
    myGraph.addEdge(6 ,7);
    myGraph.addEdge(6 ,8);
    myGraph.addEdge(6 ,9);
    myGraph.addEdge(5 ,9);
    myGraph.addEdge(7 ,10);
    myGraph.addEdge(7 ,11);

    System.out.println(myGraph.toString());

    myGraph.deleteEdge(6, 9);
    myGraph.deleteVertex(3);

    System.out.println(myGraph.toString());

    System.out.println("BFS result: " + myGraph.bfs(8, 1));
    System.out.println("DFS result: " + myGraph.dfs(8, 1));
  }
}
