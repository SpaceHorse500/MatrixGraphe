// A Java program for Dijkstra's
// single source shortest path
// algorithm. The program is for
// adjacency matrix representation
// of the graph.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DijkstrasAlgorithm {

    private static ArrayList<PathInformation> pathInformations=new ArrayList<PathInformation>();
    private static PathInformation temp;

    private static final int NO_PARENT = -1;

    // Function that implements Dijkstra's
    // single source shortest path
    // algorithm for a graph represented
    // using adjacency matrix
    // representation
    private static void dijkstra(int[][] adjacencyMatrix,
                                 int startVertex)
    {
        int nVertices = adjacencyMatrix[0].length;

        // shortestDistances[i] will hold the
        // shortest distance from src to i
        int[] shortestDistances = new int[nVertices];

        // added[i] will true if vertex i is
        // included / in shortest path tree
        // or shortest distance from src to
        // i is finalized
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as
        // INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices;
             vertexIndex++)
        {
            shortestDistances[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of source vertex from
        // itself is always 0
        shortestDistances[startVertex] = 0;

        // Parent array to store shortest
        // path tree
        int[] parents = new int[nVertices];

        // The starting vertex does not
        // have a parent
        parents[startVertex] = NO_PARENT;

        // Find shortest path for all
        // vertices
            for (int i = 1; i < nVertices; i++){
                // Pick the minimum distance vertex
                // from the set of vertices not yet
                // processed. nearestVertex is
                // always equal to startNode in
                // first iteration.
                int nearestVertex = -1;
                int shortestDistance = Integer.MAX_VALUE;
                for (int vertexIndex = 0;
                     vertexIndex < nVertices;
                     vertexIndex++)
                {
                    if (!added[vertexIndex] &&
                            shortestDistances[vertexIndex] <
                                    shortestDistance)
                    {
                        nearestVertex = vertexIndex;
                        shortestDistance = shortestDistances[vertexIndex];
                    }
                }

                // Mark the picked vertex as
                // processed
                added[nearestVertex] = true;

                // Update dist value of the
                // adjacent vertices of the
                // picked vertex.
                for (int vertexIndex = 0;
                     vertexIndex < nVertices;
                     vertexIndex++)
                {
                    int edgeDistance = adjacencyMatrix[nearestVertex][vertexIndex];

                    if (edgeDistance > 0
                            && ((shortestDistance + edgeDistance) <
                            shortestDistances[vertexIndex]))
                    {
                        parents[vertexIndex] = nearestVertex;
                        shortestDistances[vertexIndex] = shortestDistance +
                                edgeDistance;
                    }
                }
            }
        printSolution(startVertex, shortestDistances, parents);
    }



    // A utility function to print
    // the constructed distances
    // array and shortest paths
    private static void printSolution(int startVertex,
                                      int[] distances,
                                      int[] parents)
    {
        int nVertices = distances.length;
        //System.out.print("Vertex\t Distance\tPath");

        for (int vertexIndex = 0;
             vertexIndex < nVertices;
             vertexIndex++)
        {
            if (vertexIndex != startVertex)
            {
                //System.out.print("\n" + startVertex + " -> ");
                //System.out.print(vertexIndex + " \t\t ");
                //System.out.print(distances[vertexIndex] + "\t\t");
                temp=new PathInformation(startVertex,vertexIndex);
                temp.setDistance(distances[vertexIndex]);
                printPath(vertexIndex, parents);
                //System.out.println(temp);
            }
        }
    }

    // Function to print shortest path
    // from source to currentVertex
    // using parents array
    private static void printPath(int currentVertex,
                                  int[] parents)
    {

        // Base case : Source node has
        // been processed
        if (currentVertex == NO_PARENT)
        {
            pathInformations.add(temp);
            return;
        }
        printPath(parents[currentVertex], parents);
        //System.out.print(currentVertex + " ");
        temp.addPath(currentVertex);
    }

    // Driver Code
    public static void main(String[] args)
    {
        int[][] adjacencyMatrix = {{0,    500,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0},
                {500,    0,    0,    0,    1176,    587,    0,    0,    0,    0,    0,    846},
                {0,    0,    0,    0,    0,    260,    0,    0,    700,    0,    0,    0},
                {0,    0,    0,    0,    902,    548,    639,    0,    0,    0,    0,    0},
                {0,    1176,    0,    902,    0,    0,    0,    1893,    0,    0,    0,    0},
                {0,    587,    260,    548,    0,    0,    0,    0,    0,    0,    0,    0},
                {0,    0,    0,    639,    0,    0,    0,    0,    0,    1295,    2095,    0},
                {0,    0,    0,    0,    1893,    0,    0,    0,    0,    366,    0,    0},
                {0,    0,    700,    0,    0,    0,    0,    0,    0,    0,    0,    233},
                {0,    0,    0,    0,    0,    0,    1295,    366,    0,    0,    856,    0},
                {0,    0,    0,    0,    0,    0,    2095,    0,    0,    856,    0,    0},
                {0,    846,    0,    0,    0,    0,    0,    0,    233,    0,    0,    0}};
        ;
        calculateData(adjacencyMatrix);
        int startNode = 0;
        int stopNode = 2;
        //System.out.println(givePathInformation(adjacencyMatrix,startNode,stopNode));
        //System.out.println(giveSRLEA(adjacencyMatrix,"0 1 7 6 3 2"));
        WonderMap wm=new WonderMap(adjacencyMatrix);
        GenerateData generateData= new GenerateData(adjacencyMatrix);
        generateData.generate();
        generateData.displayAll();
    }

    public static PileInformation giveSRLEA(int[][] adjacencyMatrix,String strictPath) {
        String[] nodes=strictPath.split(" ");
        int pathSize = nodes.length;
        int firstNode = Integer.parseInt(nodes[0]);
        int lastNode = Integer.parseInt(nodes[pathSize-1]);
        PileInformation pi= new PileInformation();
        List<Integer> shortestPath = givePathInformationTranslated(adjacencyMatrix,firstNode,lastNode).getPath();
        //System.out.println(shortestPath.toString());
        int bias=0;
        boolean adjBool=false;
        String label;
        for(int i = 0 ; i < pathSize - 1 ; i++){
            //Compare if shortest path is equal to Strict Path
            //System.out.println(Integer.parseInt(nodes[i])+" __ "+shortestPath.get(bias));
            //System.out.println("Unmodified "+shortestPath.toString());
            if(!adjBool) {
                if (Integer.parseInt(nodes[i]) != shortestPath.get(bias)) {
                    //System.out.println("NOT EQUAL TREATMENT");
                    label = "node-SID(" + Integer.parseInt(nodes[i - 1]) + ")";
                    pi.addLabel(label);
                    firstNode=Integer.parseInt(nodes[i]);
                    //System.out.println("FIRST NODE IS "+firstNode);
                    shortestPath = givePathInformationTranslated(adjacencyMatrix,Integer.parseInt(nodes[i]),lastNode).getPath();
                    //System.out.println("SHORTEST PATH IS "+shortestPath.toString());
                    adjBool = true;
                    bias=0;
                }
                bias++;
            }else{
                if(Integer.parseInt(nodes[i]) != shortestPath.get(bias)){
                    //System.out.println("COMPARED VALUES "+Integer.parseInt(nodes[i])+" __ "+shortestPath.get(bias));
                    label="adjSID("+firstNode+","+Integer.parseInt(nodes[i])+")";
                    //System.out.println("ADDING AdjSID ("+firstNode+","+lastNode+")");
                    pi.addLabel(label);
                    firstNode=Integer.parseInt(nodes[i]);
                    //System.out.println("FIRST NODE IS "+firstNode);
                    shortestPath = givePathInformationTranslated(adjacencyMatrix,Integer.parseInt(nodes[i]),lastNode).getPath();
                    //System.out.println("SHORTEST PATH IS "+shortestPath.toString());
                    adjBool=false;
                    bias=0;
                }
                bias++;
            }
        }
        label="node-SID("+Integer.parseInt(nodes[nodes.length-1])+")";
        pi.addLabel(label);
        return pi;
    }

    private  static PathInformation givePathInformationTranslated(int[][] adjacencyMatrix, int firstNode, int lastNode) {
        return pathInformations.get(translator(adjacencyMatrix,firstNode,lastNode));
    }

    public static PileInformation giveSRLEAA(int[][] adjacencyMatrix,String strictPath) {
        String[] nodes=strictPath.split(" ");
        int pathSize = nodes.length;
        int firstNode = Integer.parseInt(nodes[0]);
        int lastNode = Integer.parseInt(nodes[pathSize-1]);
        PileInformation pi= new PileInformation();
        List<Integer> shortestPath = givePathInformationTranslated(adjacencyMatrix,firstNode,lastNode).getPath();
        //System.out.println(shortestPath.toString());
        int bias=0;
        boolean adjBool=false;
        String label;
        for(int i = 0 ; i < pathSize - 1 ; i++){
            //Compare if shortest path is equal to Strict Path
            //System.out.println(Integer.parseInt(nodes[i])+" __ "+shortestPath.get(bias));
            //System.out.println("Unmodified "+shortestPath.toString());
            if(!adjBool) {
                if (Integer.parseInt(nodes[i]) != shortestPath.get(bias)) {
                    //System.out.println("NOT EQUAL TREATMENT");
                    firstNode=Integer.parseInt(nodes[i]);
                    //System.out.println("FIRST NODE IS "+firstNode);
                    shortestPath = givePathInformationTranslated(adjacencyMatrix,Integer.parseInt(nodes[i]),lastNode).getPath();
                    //System.out.println("SHORTEST PATH IS "+shortestPath.toString());
                    adjBool = true;
                    bias=0;
                }
                bias++;
            }else{
                if(Integer.parseInt(nodes[i]) != shortestPath.get(bias)){
                    //System.out.println("COMPARED VALUES "+Integer.parseInt(nodes[i])+" __ "+shortestPath.get(bias));
                    label="adjSID("+firstNode+","+Integer.parseInt(nodes[i])+")";
                    //System.out.println("ADDING AdjSID ("+firstNode+","+lastNode+")");
                    pi.addLabel(label);
                    firstNode=Integer.parseInt(nodes[i]);
                    //System.out.println("FIRST NODE IS "+firstNode);
                    shortestPath = givePathInformationTranslated(adjacencyMatrix,Integer.parseInt(nodes[i]),lastNode).getPath();
                    //System.out.println("SHORTEST PATH IS "+shortestPath.toString());
                    adjBool=false;
                    bias=0;
                }
                bias++;
            }
        }
        label="node-SID("+Integer.parseInt(nodes[nodes.length-1])+")";
        pi.addLabel(label);
        return pi;
    }


    public static PathInformation givePathInformationTranslated(int[][] adjacencyMatrix,int value) {
        System.out.println(value+" -> "+translator(adjacencyMatrix,value));
        return pathInformations.get(translator(adjacencyMatrix,value));
    }

    private static void calculateData(int[][] adjacencyMatrix) {
        int nVertices = adjacencyMatrix[0].length;
        for(int i=0; i<nVertices ; i++){
            dijkstra(adjacencyMatrix, i);
        }
    }

    private static int translator(int[][] adjacencyMatrix,int x,int y) {
        int size=adjacencyMatrix[0].length;
        Assosiation assosiation=new Assosiation(adjacencyMatrix);
        return assosiation.translate.get(size*x+y);
    }

    private static int translator(int[][] adjacencyMatrix,int value) {
        Assosiation assosiation=new Assosiation(adjacencyMatrix);
        return assosiation.translate.get(value);
    }

    public static PathInformation givePathInformation(int[][] adjacencyMatrix, int value) {
        return pathInformations.get(value);
    }
}
