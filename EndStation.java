public class EndStation extends Station {
    public EndStation(String s, String n) {
        super(s, n);
        // next = null;
        // prev = null;
        inService = true;
    }

    // maybe throw some exceptions if null? we will see
    public void makeEnd() {
        if(next != null) {
            prev = next;
        }
        next = prev;
    }

    // toString for EndStations
    public String toString() {
        String prevStr = "";
        String nextStr = "";
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
        return "ENDSTATION " + name + ": " + color + " line, in service: " + inService + ", previous station: "
                + prevStr + ", next station: " + nextStr;
    }
}
