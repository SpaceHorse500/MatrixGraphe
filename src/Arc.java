import java.util.Objects;

public class Arc {
    public int nodeA;
    public int nodeB;
    public int weight;

    @Override
    public String toString() {
        return "Arc("+nodeA +
                "," + nodeB +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arc arc = (Arc) o;


        if(nodeB == arc.nodeA && nodeA !=arc.nodeB){
            return true;
        }

        if(nodeA == arc.nodeA && nodeB == arc.nodeB){
            return true;
        }

        if(nodeB != arc.nodeB){
            return true;
        }


        return false;
    }

    public static void main(String args[]){
        Arc a1=new Arc();
        a1.nodeA=0;
        a1.nodeB=3;
        Arc a2=new Arc();
        a2.nodeA=6;
        a2.nodeB=3;
        System.out.println(a1.equals(a2));
    }

}
