import java.util.ArrayList;
import java.util.List;

public class ArtExhibition {
    // Внутренний класс Painting для хранения информации о картинах
    public class Painting {
        private String title;
        private String artist;
        private String exhibitionDate;

        // Конструктор внутреннего класса
        public Painting(String title, String artist, String exhibitionDate) {
            this.title = title;
            this.artist = artist;
            this.exhibitionDate = exhibitionDate;
        }

        // Методы set и get
        public void setTitle(String title) { this.title = title; }
        public String getTitle() { return title; }

        public void setArtist(String artist) { this.artist = artist; }
        public String getArtist() { return artist; }

        public void setExhibitionDate(String exhibitionDate) { this.exhibitionDate = exhibitionDate; }
        public String getExhibitionDate() { return exhibitionDate; }

        // Переопределение метода toString для представления объекта в виде строки
        @Override
        public String toString() {
            return "Painting{" +
                    "title='" + title + '\'' +
                    ", artist='" + artist + '\'' +
                    ", exhibitionDate='" + exhibitionDate + '\'' +
                    '}';
        }
    }

    // Список картин на выставке
    private List<Painting> paintings;

    // Конструктор класса ArtExhibition
    public ArtExhibition() {
        paintings = new ArrayList<>();
    }

    // Метод для добавления новой картины
    public void addPainting(String title, String artist, String exhibitionDate) {
        Painting painting = new Painting(title, artist, exhibitionDate);
        paintings.add(painting);
    }

    // Метод для получения списка всех картин
    public List<Painting> getPaintings() {
        return paintings;
    }

    // Метод для поиска картины по названию
    public Painting findPaintingByTitle(String title) {
        for (Painting painting : paintings) {
            if (painting.getTitle().equalsIgnoreCase(title)) {
                return painting;
            }
        }
        return null; // Если картина не найдена
    }

    public static void main(String[] args) {
        ArtExhibition exhibition = new ArtExhibition();

        // Добавление картин
        exhibition.addPainting("Starry Night", "Vincent van Gogh", "2024-06-15");
        exhibition.addPainting("Mona Lisa", "Leonardo da Vinci", "2024-07-01");
        exhibition.addPainting("The Persistence of Memory", "Salvador Dali", "2024-08-20");

        // Получение списка всех картин
        System.out.println("All Paintings:");
        for (Painting painting : exhibition.getPaintings()) {
            System.out.println(painting);
        }

        // Поиск картины по названию
        System.out.println("\nSearch Painting by Title:");
        Painting foundPainting = exhibition.findPaintingByTitle("Mona Lisa");
        if (foundPainting != null) {
            System.out.println(foundPainting);
        } else {
            System.out.println("Painting not found");
        }
    }
}
