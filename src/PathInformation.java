import java.util.ArrayList;
import java.util.List;

public class PathInformation {
    int firstNode;
    int lastNode;
    int distance;
    List<Integer> path;

    public PathInformation(int firstNode,int lastNode) {
        this.firstNode = firstNode;
        this.lastNode = lastNode;
        this.path=new ArrayList<Integer>();
    }

    public PathInformation() {
        this.path=new ArrayList<Integer>();
    }

    public int getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(int firstNode) {
        this.firstNode = firstNode;
    }

    public int getLastNode() {
        return lastNode;
    }

    public void setLastNode(int lastNode) {
        this.lastNode = lastNode;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<Integer> getPath() {
        return path;
    }

    public void addPath(int node) {
        this.path.add(node);
    }

    @Override
    public String toString() {
        return "Vertex " + firstNode +
                " -> " + lastNode +
                ", Distance = " + distance +
                ", Path= " + path ;
    }
}
