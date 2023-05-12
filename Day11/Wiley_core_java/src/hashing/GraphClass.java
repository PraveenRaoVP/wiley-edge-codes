package hashing;

import java.util.*;

class GraphClass {
    static void insert(ArrayList<ArrayList<Integer> > adj,
                        int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
 

    static void printGraph(ArrayList<ArrayList<Integer> > adj)
    {
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex"
                               + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "
                                 + adj.get(i).get(j));
            }
            System.out.println();
        }
    }
 
    public static void main(String[] args)
    {
        int vertex = 5;
        ArrayList<ArrayList<Integer> > graph
            = new ArrayList<ArrayList<Integer> >(vertex);
 
        for (int i = 0; i < vertex; i++)
            graph.add(new ArrayList<Integer>());
        insert(graph, 0, 1);
        insert(graph, 0, 4);
        insert(graph, 1, 2);
        insert(graph, 1, 3);
        insert(graph, 1, 4);
        insert(graph, 2, 3);
        insert(graph, 3, 4);
 
        printGraph(graph);
    }
}


