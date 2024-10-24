import java.util.ArrayList;

public class Station {
    // doubly linked list structure
    String color;
    String name;
    boolean inService;
    Station next;
    Station prev;

    // constructor
    public Station(String c, String n) {
        this.color = c;
        this.name = n;
        // idk if I have to include these yet?
        inService = true;
        // next = null;
        // prev = null;
    }

    // need to double check if this is hard coded? I don't think so but just to be
    // sure
    public boolean equals(Station other) {
        if (other.name.equals(this.name) && other.color.equals(this.color)) {
            return true;
        }
        return false;
    }

    // i thought this was the same as addnext
    public void connect(Station other) {
        this.next = other;
        other.prev = this;
    }

    // assign next value
    public void addNext(Station other) {
        this.next = other;
        other.prev = this;
    }

    // assign previous value
    public void addPrev(Station other) {
        this.prev = other;
        other.next = this;
    }

    // just return boolean value. starts off as true
    public boolean isAvailable() {
        return inService;
    }

    // switch boolean value
    public void switchAvailable() {
        if (inService) {
            inService = false;
        } else {
            inService = true;
        }
    }

    public int tripLength(Station other) {
        // use recursion
        // so basically the steps from this to other
        // iterator
        Station temp = this;
        ArrayList<Station> list = new ArrayList<>();
        // adding this here b/c it removed an error
        Station temporary = new Station("??", "??");
        list.add(temporary);
        return recursiveHelper(other, temp, 0, list);
    }

    public int recursiveHelper(Station other, Station it, int value, ArrayList<Station> visitedStations) {
        // Station it = iterator;
        // int currentVal = value;
        // base case, if the current station is equal to the desired station
        if (it.equals(other)) {
            return value;
        }
        // index out of range
        else if ((visitedStations.contains(it))) {
            // means it looped
            return -1;
        }

        else {
            // otherwise, add it to visited, inv val, parse, and recurse
            // i had if next == null but I don't think I need this here
            visitedStations.add(it);
            value++;
            // inc iterator
            System.out.println("Before: " + it.toString());
            System.out.println("After: " + it.toString());
            System.out.println("Value: " + value);

            //if it is
            if ((it instanceof TransferStation)) {
                TransferStation temp = (TransferStation)it;
                for (int i = 0; i < temp.otherStations.size(); i++) {
                    int tempVar = recursiveHelper(other, temp.otherStations.get(i), value, visitedStations);
                    if (tempVar != -1) {
                        return recursiveHelper(other, temp.otherStations.get(i), value, visitedStations);
                    }
                }
            }
            
            it = it.next;
            return recursiveHelper(other, it, value, visitedStations);
        }

        // all else fails
        // return 0;
    }

    // have other methods for endstation and transferstation
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
        return "STATION " + name + ": " + color + " line, in service: " + inService + ", previous station: " + prevStr
                + ", next station: " + nextStr;
    }

}
