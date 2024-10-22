public class Station {
    String color;
    String name;
    boolean inService;
    Station next;
    Station prev;
    public Station(String c, String n) {
        this.color = c;
        this.name = n;
        //idk if I have to include these yet?
        inService = true;
        next = null;
        prev = null;
    }

    public void connect(Station other) {

    }

    public void addNext(Station other) {
        this.next = other;
    }

    public void addPrev(Station other) {
        this.prev = other;
    }

    public void switchAvailable() {

    }

    public int tripLength(Station other) {
        //use recursion
        return 0;
    }

    //"STATION Museum: pink line, in service: true, previous station: none, next station: none";
    public String toString() {
        String prevStr = "";
        String nextStr = "";
        if(prev == null) {
            prevStr = "none";
        }
        else {
            prevStr = prev.name;
        }
        if(next == null) {
            nextStr = "none";
        }
        else {
            nextStr = next.name;
        }
        return "STATION " + name + ": " + color + " line, in service: " + inService + ", previous station: " + prevStr + ", next station: " + nextStr;
    }

}
