public class Main {
    public static void main(String[] args) {
        // Создание объекта Manager
        Manager manager = new Manager("Alice", "Engineering", 120000, 5);

        // Вывод информации о менеджере
        System.out.println("Manager Details:");
        manager.getDetails();

        // Выполнение обязанностей менеджера
        System.out.println("\nManager Duties:");
        manager.performDuties();
        // Создание объекта Theater
        String[] shows = {"Hamlet", "Macbeth", "Othello"};
        Theater theater = new Theater("Grand Theater", "123 Main St", 500, shows);

        // Вывод информации о театре
        System.out.println("Theater Details:");
        theater.getDetails();

        // Вывод вместимости театра
        System.out.println("\nTheater Capacity:");
        theater.getCapacity();
    }

}
