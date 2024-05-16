import java.util.ArrayList;
import java.util.List;
public class Mobile {
    // Внутренний класс Model для хранения информации о моделях телефонов
    public class Model {
        private String modelName;
        private String brand;
        private double price;
        private String[] features;

        // Конструктор внутреннего класса
        public Model(String modelName, String brand, double price, String[] features) {
            this.modelName = modelName;
            this.brand = brand;
            this.price = price;
            this.features = features;
        }

        // Методы set и get
        public void setModelName(String modelName) { this.modelName = modelName; }
        public String getModelName() { return modelName; }

        public void setBrand(String brand) { this.brand = brand; }
        public String getBrand() { return brand; }

        public void setPrice(double price) { this.price = price; }
        public double getPrice() { return price; }

        public void setFeatures(String[] features) { this.features = features; }
        public String[] getFeatures() { return features; }

        // Переопределение метода toString для представления объекта в виде строки
        @Override
        public String toString() {
            return "Model{" +
                    "modelName='" + modelName + '\'' +
                    ", brand='" + brand + '\'' +
                    ", price=" + price +
                    ", features=" + String.join(", ", features) +
                    '}';
        }
    }

    // Список моделей телефонов
    private List<Model> models;

    // Конструктор класса Mobile
    public Mobile() {
        models = new ArrayList<>();
    }

    // Метод для добавления новой модели телефона
    public void addModel(String modelName, String brand, double price, String[] features) {
        Model model = new Model(modelName, brand, price, features);
        models.add(model);
    }

    // Метод для получения списка всех моделей
    public List<Model> getModels() {
        return models;
    }

    // Метод для поиска модели по названию
    public Model findModelByName(String modelName) {
        for (Model model : models) {
            if (model.getModelName().equalsIgnoreCase(modelName)) {
                return model;
            }
        }
        return null; // Если модель не найдена
    }

    public static void main(String[] args) {
        Mobile mobileStore = new Mobile();

        // Добавление моделей телефонов
        mobileStore.addModel("iPhone 14", "Apple", 999.99, new String[]{"5G", "128GB Storage", "6GB RAM"});
        mobileStore.addModel("Galaxy S22", "Samsung", 899.99, new String[]{"5G", "256GB Storage", "8GB RAM"});
        mobileStore.addModel("Pixel 7", "Google", 799.99, new String[]{"5G", "128GB Storage", "8GB RAM"});

        // Получение списка всех моделей
        System.out.println("All Models:");
        for (Model model : mobileStore.getModels()) {
            System.out.println(model);
        }

        // Поиск модели по названию
        System.out.println("\nSearch Model by Name:");
        Model foundModel = mobileStore.findModelByName("iPhone 14");
        if (foundModel != null) {
            System.out.println(foundModel);
        } else {
            System.out.println("Model not found");
        }
    }
}
