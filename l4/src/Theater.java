public class Theater extends PublicBuilding {
    private String[] shows;

    public Theater(String name, String address, int capacity, String[] shows) {
        super(name, address, capacity);
        this.shows = shows;
    }

    @Override
    public void getCapacity() {
        System.out.println("Theater Capacity: " + capacity + " seats");
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("Shows: " + String.join(", ", shows));
    }
}
