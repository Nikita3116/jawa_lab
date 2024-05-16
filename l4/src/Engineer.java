public abstract class Engineer implements Employee {
    protected String name;
    protected String department;
    protected double salary;

    public Engineer(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public void getDetails() {
        System.out.println("Name: " + name + ", Department: " + department + ", Salary: $" + salary);
    }

    @Override
    public abstract void performDuties(); // Абстрактный метод, должен быть реализован в подклассах
}
