public abstract class PublicBuilding implements Building {
    protected String name;
    protected String address;
    protected int capacity;

    public PublicBuilding(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    @Override
    public void getDetails() {
        System.out.println("Name: " + name + ", Address: " + address + ", Capacity: " + capacity);
    }

    @Override
    public abstract void getCapacity(); // Абстрактный метод, должен быть реализован в подклассах
}
