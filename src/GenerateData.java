import java.util.ArrayList;
import java.util.Arrays;

public class GenerateData {

    public static int ATTEMPT = 10000;
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
                    System.out.print("Creation route : "+i+" : "+j);
                    UniquePaths uniquePaths = wm.generateUniquePaths(i, j, ATTEMPT);
                    DataTable dt = new DataTable(this.adjacencyMatrix);
                    dt.addPath(uniquePaths);
                    dataTables.add(dt);
                    System.out.print("  ==> "+dt.uniquePaths.listPath.size()+" routes added.\n");
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
            for(int i = 1 ; i < size ; i++){
                String[] vals=this.dataTables.get(value).getStrictPath(i).split(" ");
                System.out.print(DijkstrasAlgorithm.givePathInformation(adjacencyMatrix,value).path+";");
                System.out.print(Arrays.toString(vals)+";");
                System.out.print(vals.length+";");
                System.out.print(this.dataTables.get(value).getSRLEAPath(i)+";");
                System.out.print(this.dataTables.get(value).getSRLEAPathLen(i)+";");
                System.out.print(this.dataTables.get(value).getSRLEAAPath(i)+";");
                System.out.print(this.dataTables.get(value).getSRLEAAPathLen(i)+";");
                System.out.print("\n");

            }
        }
    }

}
