import java.util.ArrayList;

public class DataTable {
    public UniquePaths uniquePaths;

    public DataTable(int[][] matrix) {
        this.matrix = matrix;
    }

    private int[][] matrix;
    private String strictPath;
    private String LEA;

    public void addPath(UniquePaths uniquePaths) {
        this.uniquePaths=uniquePaths;
    }

    public String getStrictPath(int index){
        return ArcsPath.toPath(this.uniquePaths.listPath.get(index));
    }
    public String getSRLEAPath(int index){
        return DijkstrasAlgorithm.giveSRLEA(matrix,this.getStrictPath(index)).toString();
    }

    public String getSRLEAAPath(int index){
        return DijkstrasAlgorithm.giveSRLEAA(matrix,this.getStrictPath(index)).toString();
    }

    public int getSRLEAAPathLen(int index){
        return DijkstrasAlgorithm.giveSRLEAA(matrix,this.getStrictPath(index)).getSids().size();
    }

    public int getSRLEAPathLen(int index){
        return DijkstrasAlgorithm.giveSRLEA(matrix,this.getStrictPath(index)).getSids().size();
    }


}
