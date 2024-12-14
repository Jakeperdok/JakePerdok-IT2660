class Main {
  public static void main(String[] args) {
    String[] vertices = { "Business & Technology", "Theatre", "Liberal Arts", "Student Services", "Technology Learning Center", "Recreation Center", "Health Technologies Center", 
    "Health Careers & Sciences"};

    int[][] edges = {
      {0, 1}, // BT - T
      {1, 2}, // T - LA
      {2, 3}, // LA - SS
      {3, 4}, // SS - TLC
      {4, 5}, // TLC - RC
      {5, 6}, // RC - HT
      {6, 7}, // HT - HCS
      {7, 3}, // HCS - SS
      {3, 0}, // SS - BT
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology")); // Get a dfs starting at the Business and Technology Building. Change this is you called it something different in your vertices!

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
          " is " + graph.getVertex(dfs.getParent(i)));
          
    dfs.printPath(graph.getIndex("Health Technologies Center"));
    System.out.println();
    dfs.printPath(graph.getIndex("Student Services"));
    System.out.println();
    dfs.printPath(graph.getIndex("Recreation Center"));
    System.out.println();

    dfs.printTree();

    
  }
}