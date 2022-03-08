import java.util.ArrayList;

public class PileInformation {

    private ArrayList<String> sids;

    public PileInformation() {
        this.sids = new ArrayList<>();
    }

    public ArrayList<String> getSids() {
        return sids;
    }

    public void setSids(ArrayList<String> sids) {
        this.sids = sids;
    }

    public void addLabel(String label) {
        this.sids.add(label);
    }

    @Override
    public String toString() {
        return this.sids.toString() ;
    }
}
