public class Station {
    //doubly linked list structure
    String color;
    String name;
    boolean inService;
    Station next;
    Station prev;

    //constructor
    public Station(String c, String n) {
        this.color = c;
        this.name = n;
        //idk if I have to include these yet?
        inService = true;
        next = null;
        prev = null;
    }

    //i thought this was the same as addnext
    public void connect(Station other) {
        this.next = other;
        other.prev = this;
    }

    //assign next value
    public void addNext(Station other) {
        this.next = other;
    }
    
    //assign previous value
    public void addPrev(Station other) {
        this.prev = other;
    }

    //just return boolean value. starts off as true
    public boolean isAvailable() {
        return inService;
    }

    //switch boolean value
    public void switchAvailable() {
        if(inService) {
            inService = false;
        }
        else {
            inService = true;
        }
    }   

    //hardest method
    public int tripLength(Station other) {
        
        //use recursion
        return 0;
    }

    //have other methods for endstation and transferstation
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
