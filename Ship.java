public class Ship {
    private String name;
    private int length;
    private ArrayList<String> locations;

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
        this.locations = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public ArrayList<String> getLocations() {
        return locations;
    }

    public void setLocation(String location) {
        locations.add(location);
    }

    public boolean isSunk() {
        return locations.size() == length;
    }
}
