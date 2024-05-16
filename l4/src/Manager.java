public class Manager extends Engineer {
    private int numberOfReports;

    public Manager(String name, String department, double salary, int numberOfReports) {
        super(name, department, salary);
        this.numberOfReports = numberOfReports;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is managing " + numberOfReports + " reports.");
    }

    @Override
    public void getDetails() {
        super.getDetails();
        System.out.println("Number of Reports: " + numberOfReports);
    }
}
