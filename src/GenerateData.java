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
        for(int i = 0 ; i < this.nVerticies ; i++){
            for(int j = 0 ; j < this.nVerticies ; j++){
                if(i!=j) {
                    UniquePaths uniquePaths = wm.generateUniquePaths(i, j, 100);
                    DataTable dt = new DataTable(this.adjacencyMatrix);
                    dt.addPath(uniquePaths);
                    dataTables.add(dt);
                }
            }
        }
    }

    public DataTable getDataTable(int x,int y){
        return this.dataTables.get(this.nVerticies*x+y);
    }

    public DataTable getDataTable(int value){
        return this.dataTables.get(value);
    }

    public void displayAll() {
        for(int value=0 ; value< this.dataTables.size() ; value++){
            int size=this.dataTables.get(value).uniquePaths.listPath.size();
            for(int i = 0 ; i < size ; i++){
                System.out.println(DijkstrasAlgorithm.givePathInformation(adjacencyMatrix,value).path);
                System.out.println(this.dataTables.get(value).getStrictPath(i));
                System.out.println(this.dataTables.get(value).getSRLEAPath(i));
                System.out.println(this.dataTables.get(value).getSRLEAAPath(i));
            }
        }
    }

}
