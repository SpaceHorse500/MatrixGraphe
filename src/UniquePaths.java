import java.util.ArrayList;

public class UniquePaths {

    public ArrayList<ArrayList<Arc>> listPath=new ArrayList<>();

    @Override
    public String toString() {
        String resultat="";
        for(ArrayList<Arc> a : listPath){
            resultat+=a.toString()+"\n";
        }
        return resultat;
    }
}
