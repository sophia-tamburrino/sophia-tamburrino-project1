import java.util.ArrayList;

public class TransferStation extends Station {
    // arraylist of stations!
    ArrayList<Station> otherStations = new ArrayList<Station>();
    Station transferNext;
    Station transferPrev;

    public TransferStation(String s, String n) {
        super(s, n);
        // next = null;
        // prev = null;
        inService = true;
    }

    //will use after first connection
    public void addTransferStationNext(Station other) {
        otherStations.add(other);
        transferNext = other;
        other.prev = this;
    }

    //use after first connection
    public void addTransferStationPrev(Station other) {
        otherStations.add(other);
        transferPrev = other;
        other.next = this;
    }

    // have to include other transfers here from this station, so their toStrings
    // from the arraylist?
    public String toString() {
        String prevStr = "";
        String nextStr = "";
        String transfers = "";
        if (prev == null) {
            prevStr = "none";
        } else {
            prevStr = prev.name;
        }
        if (next == null) {
            nextStr = "none";
        } else {
            nextStr = next.name;
        }
        for (int i = 0; i < otherStations.size(); i++) {
            transfers += "\t" + otherStations.get(i).toString() + "\n";
        }
        // INCLUDE TRANSFERS
        return "TRANSFERSTATION " + name + ": " + color + " line, in service: " + inService + ", previous station: "
                + prevStr + ", next station: " + nextStr + "\n\tTransfers: \n" + transfers;
    }
}
