package com.company.algorithm.graph;

import java.util.*;

public class DirectedGraph {

    private int n;
    private Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public void addVertex(int vertex){
        adjacencyList.put(vertex, new LinkedList<>());
        n++;
    }

    public void addEdge(int source, int destination){

        if(!adjacencyList.containsKey(source))
            addVertex(source);

        if(!adjacencyList.containsKey(destination))
            addVertex(destination);

        adjacencyList.get(source).add(destination);

    }

    public int getVertexCount(){
        return this.n;
    }

    public int getEdgeCount(){

        if(adjacencyList.size() <= 0)
            return 0;

        int count = 0;
        for(Integer vertex : adjacencyList.keySet()){
            count += adjacencyList.get(vertex).size();
        }

        return count;
    }

    public boolean hasEdge(int source, int destination) {

        if(!adjacencyList.containsKey(source))
            return false;

        for (Integer dest : adjacencyList.get(source)) {
            if(dest == destination)
                return true;
        }

        return false;
    }

    public boolean hasVertex(int vertex) {
        return adjacencyList != null && adjacencyList.containsKey(vertex);
    }

    public void bfs(int source){

        System.out.println("Bread First Search");
        if(!adjacencyList.containsKey(source)){
            System.out.println("Invalid source to start traversal");
        }

        Map<Integer, Boolean> visited = new HashMap<>(); // default all are not visited so all are null;
        Queue<Integer> queue = new LinkedList(); //  breadth first uses Queue for traversal

        visited.put(source, true);
        queue.add(source);


        while(queue.size() != 0){

            Integer s = queue.poll();
            System.out.print(s +" ");
            List<Integer> connectedVertexes = adjacencyList.get(s);
            for (Integer vertex : connectedVertexes) {

                if(visited.get(vertex) == null) {
                    queue.add(vertex);
                    visited.put(vertex, true);
                }
            }

        }

        System.out.println();
        System.out.println("=====================================");

    }

    public DirectedGraph clone(int source){

        DirectedGraph directedGraph = new DirectedGraph();

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        queue.add(source);
        visited.put(source, true);

        while(!queue.isEmpty()){

            int s = queue.poll();

            List<Integer> neighbours = adjacencyList.get(s);


                    for (Integer neighbour : neighbours){

                        if(visited.get(neighbour)  ==  null) {

                            directedGraph.addEdge(s, neighbour);
                            queue.add(neighbour);
                            visited.put(neighbour, true);
                        }
                    }

        }
        return directedGraph;

    }

    public boolean hasCycle(int source){
        if(!adjacencyList.containsKey(source)){
            System.out.println("Invalid source to start traversal");
        }

        Set<String> edges = new HashSet<>(); // default all are not visited so all are null;
        Queue<Integer> queue = new LinkedList(); //  breadth first uses Queue for traversal
        queue.add(source);
        while(queue.size() != 0){
            Integer s = queue.poll();
            List<Integer> connectedVertexes = adjacencyList.get(s);
            for (Integer vertex : connectedVertexes) {

                if(edges.contains(getEdgeOppPattern(s, vertex)))
                    return true;

                edges.add(getEdgeOppPattern(s, vertex));
                queue.add(vertex);
            }
        }
        return false;
    }

    private String getEdgeOppPattern(Integer source , Integer vertex) {
        return vertex +"-->"+source;
    }

}

class Driver{
    public static void main(String[] arg){

        DirectedGraph graph = new DirectedGraph();
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("vertex count : "+graph.getVertexCount());
        System.out.println("Edge count : "+graph.getEdgeCount());
        System.out.println("has Edge : "+graph.hasEdge(1, 0));
        System.out.println("has Edge : "+graph.hasEdge(2, 3));

        System.out.println("has vertex : "+graph.hasVertex(4));

        graph.bfs(2); /// traversal using breadfirst search
        System.out.println("has cycle : "+graph.hasCycle(0));
        graph.clone(2);


    }
}
