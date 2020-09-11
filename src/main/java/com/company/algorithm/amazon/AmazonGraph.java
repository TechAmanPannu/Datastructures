package com.company.algorithm.amazon;

import java.util.*;

public class AmazonGraph {

    private int n;
    private Map<String, List<String>> adjacencyList = new HashMap<>();

    public void addVertex(String vertex){
        adjacencyList.put(vertex, new LinkedList<>());
        n++;
    }

    public void addEdge(String source, String destination){

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
        for(String vertex : adjacencyList.keySet()){
            count += adjacencyList.get(vertex).size();
        }

        return count;
    }

    public boolean hasEdge(String source, String destination) {

        if(!adjacencyList.containsKey(source))
            return false;

        List<String> array = new ArrayList<>();
         for (String s : array) {
                System.out.println();
        }
        for (String dest : adjacencyList.get(source)) {
            if(dest == destination)
                return true;
        }

        return false;
    }

    public boolean hasVertex(String vertex) {
        return adjacencyList != null && adjacencyList.containsKey(vertex);
    }

    public void bfs(String source){

        System.out.println("Bread First Search");
        if(!adjacencyList.containsKey(source)){
            System.out.println("Invalid source to start traversal");
        }

        Map<String, Boolean> visited = new HashMap<>(); // default all are not visited so all are null;
        Queue<String> queue = new LinkedList(); //  breadth first uses Queue for traversal

        visited.put(source, true);
        queue.add(source);


        while(queue.size() != 0){

            String s = queue.poll();
            System.out.print(s +" ");
            List<String> connectedVertexes = adjacencyList.get(s);
            for (String vertex : connectedVertexes) {

                if(visited.get(vertex) == null) {
                    queue.add(vertex);
                    visited.put(vertex, true);
                }
            }

        }

        System.out.println();
        System.out.println("=====================================");

    }

    public void solveWithBFS(){
        Map<Integer, List<List<String>>> sizemap = new HashMap<>();
        int maxassoc = Integer.MIN_VALUE;

        for (String key : adjacencyList.keySet()) {
            Queue<String> q = new LinkedList<>();
            TreeSet<String> temp = new TreeSet<>();
            q.add(key);
            while (!q.isEmpty()) {
                String head = q.poll();
                temp.add(head);
                List<String> tail = adjacencyList.get(head);
                for (String t : tail) {
                    q.add(t);
                }
            }
            int size = temp.size();
           // System.out.println("temp "+temp);
            maxassoc = Math.max(maxassoc, size);
            if (!sizemap.containsKey(size)) {
                sizemap.put(size, new ArrayList<>());
            }
            sizemap.get(size).add(new ArrayList<>(temp));
        }

        // Retrieve the maximum size lists and sort them lexiographically
        List<List<String>> maxassoclist = sizemap.get(maxassoc);
        
        Collections.sort(maxassoclist, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                int result = 0;
                for (int i = 0; i < o1.size() && result == 0; i++) {
                    result = o1.get(i).compareTo(o2.get(i));
                }
                return result;
            }
        });

        System.out.println(maxassoclist.get(0));

    }

    public static void main(String arg[]){

        AmazonGraph graph = new AmazonGraph();
        graph.addEdge("item1", "item2");
        graph.addEdge("item3","item4");
        graph.addEdge("item4", "item5");
        graph.solveWithBFS();

    }
}
