import java.util.HashMap;

public class Assosiation {

    public HashMap<Integer,Integer> translate;

    public Assosiation(int[][] matrix){
        this.translate=new HashMap<>();
        int size=matrix[0].length;
        int counter=0;
        for(int i=0 ; i< size ; i++){
            for(int j=0 ; j< size ; j++){
                if(i!=j){
                    int value=size*i+j;
                    this.translate.put(value,counter);
                    counter++;
                    //System.out.println(this.translate);
                }
            }
        }

    }
}
