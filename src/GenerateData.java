import java.util.ArrayList;

public class GenerateData {
    private int[][] adjacencyMatrix;
    private int nVerticies;
    private ArrayList<DataTable> dataTables;

    public GenerateData(int[][] adjacencyMatrix){
        this.adjacencyMatrix=adjacencyMatrix;
        this.nVerticies=this.adjacencyMatrix[0].length;
        this.dataTables=new ArrayList<>();
    }

    public void generate(){
        WonderMap wm=new WonderMap(adjacencyMatrix);
        for(int i =0 ; i < this.nVerticies ; i++){
            for(int j =0 ; j < this.nVerticies ; j++){
                UniquePaths uniquePaths = wm.generateUniquePaths(i, j, 100);
                DataTable dt=new DataTable(this.adjacencyMatrix);
                dt.addPath(uniquePaths);
                dataTables.add(dt);
            }
        }
    }

    public DataTable getDataTable(int x,int y){
        return this.dataTables.get(this.nVerticies*x+y);
    }

    public void displayAll() {
        for(int i=0 ; i< this.nVerticies ; i++){
            for(int j=0 ; j< this.nVerticies ; j++){
                int size=this.getDataTable(i,j).uniquePaths.listPath.size();
                for(int k=0 ; k < size-1 ; k++){
                    System.out.println(this.getDataTable(i,j).uniquePaths.listPath.get(k));
                    System.out.println("Strict Path : "+this.getDataTable(i,j).getStrictPath(k));
                    System.out.println("SR LEA : "+this.getDataTable(i,j).getSRLEAPath(k));
                    System.out.println("Disjtra Path : "+DijkstrasAlgorithm.givePathInformation(adjacencyMatrix,i,j).path);
                    System.out.println("---------------------------------");
                }
            }
        }
    }
}
