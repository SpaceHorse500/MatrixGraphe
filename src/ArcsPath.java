import java.util.ArrayList;

public class ArcsPath {

    public static String toPath(ArrayList<Arc> arcs){
        String result =""+ arcs.get(0).nodeA+" ";
        for(int i = 0 ; i < arcs.size() ; i++){
            result+=arcs.get(i).nodeB+" ";
        }
        return result;
    }
}
