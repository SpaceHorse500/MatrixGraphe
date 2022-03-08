import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WonderMap {

    private int[][] adjacencyMatrix;
    private int nVerticies;
    private ArrayList<Arc> path;

    public WonderMap(int[][] adjacencyMatrix){
        this.adjacencyMatrix=adjacencyMatrix;
        this.nVerticies=this.adjacencyMatrix[0].length;
    }

    public ArrayList<Arc> getPath(int source, int destination){
        Arc currentNode=new Arc();
        currentNode.nodeB=source;
        Arc temp=new Arc();
        this.path = new ArrayList<>();
        do{
            int tries=this.nVerticies;
            do{
                tries--;
                temp = findNextLinkRandom(currentNode.nodeB);
                //System.out.println(temp);
                if(temp!=null){
                    currentNode=temp;
                }
                if(tries <=0 ){
                    tries=this.nVerticies;
                    this.path.remove(this.path.size()-1);
                }
            }while(currentNode == null);


            this.path.add(currentNode);
            //System.out.println(currentNode);
        }while(destination!=currentNode.nodeB);
        return this.path;
    }

    private Arc findNextLink(int source,int starting) {
        Arc arc=new Arc();
        int stopLoop=0;
        for(int i = starting ; i < this.nVerticies+starting ; i++){
            stopLoop++;
            if(this.adjacencyMatrix[source][i]!=0){
                arc.nodeA=source;
                arc.nodeB=i;
                arc.weight=this.adjacencyMatrix[source][i%this.nVerticies];
                return arc;
            }
        }
        return null;
    }

    private Arc findNextLinkRandom(int source) {
        Arc arc=new Arc();
        int stopLoop=0;
        int starting = (int) (Math.random()*(this.nVerticies-1));
        for(int i = starting ; stopLoop<=this.nVerticies; i++){
            stopLoop++;
            //System.out.println("Source : "+source +" Vertices : "+i%this.nVerticies);
            if(this.adjacencyMatrix[source][(i%this.nVerticies)]!=0){
                //System.out.println("Path option");
                arc.nodeA=source;
                arc.nodeB=i%this.nVerticies;
                arc.weight=this.adjacencyMatrix[source][(i%this.nVerticies)];
                return arc;
            }
        }
        return null;
    }


    public UniquePaths generateUniquePaths(int source, int destination, int tries){
        UniquePaths uniquePaths= new UniquePaths();
        ArrayList<Arc> temp= new ArrayList<>();
        for(int i = 0 ; i < tries ; i++){
            temp= this.getPath(source,destination);
            if(!uniquePaths.listPath.contains(temp)){
                if(repeating(ArcsPath.toPath(temp))){
                   //System.out.println(ArcsPath.toPath(temp));
                   uniquePaths.listPath.add(temp);
               }
            }
        }
        return uniquePaths;
    }

    public static boolean repeating(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (repeating.contains(letter)) {
                continue; }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character) letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.size()==word.split(" ").length;
    }

}
