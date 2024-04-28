public class Patient {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String address;
    private String phone;
    private String medicalCardNumber;
    private String diagnosis;

    // Конструктор
    public Patient(int id, String lastName, String firstName, String middleName,
                   String address, String phone, String medicalCardNumber, String diagnosis) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        this.medicalCardNumber = medicalCardNumber;
        this.diagnosis = diagnosis;
    }

    // Методы set и get для каждого поля
    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public String getMiddleName() { return middleName; }

    public void setAddress(String address) { this.address = address; }
    public String getAddress() { return address; }

    public void setPhone(String phone) { this.phone = phone; }
    public String getPhone() { return phone; }

    public void setMedicalCardNumber(String medicalCardNumber) { this.medicalCardNumber = medicalCardNumber; }
    public String getMedicalCardNumber() { return medicalCardNumber; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public String getDiagnosis() { return diagnosis; }

    // toString метод для представления объекта в виде строки
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", medicalCardNumber='" + medicalCardNumber + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }

    // Метод для вывода списка пациентов с данным диагнозом
    public static void printPatientsWithDiagnosis(Patient[] patients, String diagnosis) {
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equalsIgnoreCase(diagnosis)) {
                System.out.println(patient);
            }
        }
    }

    // Метод для вывода списка пациентов, номер медицинской карты которых находится в заданном интервале
    public static void printPatientsByMedicalCardRange(Patient[] patients, String minNumber, String maxNumber) {
        for (Patient patient : patients) {
            if (patient.getMedicalCardNumber().compareTo(minNumber) >= 0 &&
                    patient.getMedicalCardNumber().compareTo(maxNumber) <= 0) {
                System.out.println(patient);
            }
        }
    }

    public static void main(String[] args) {
        // Создание массива объектов класса Patient
        Patient[] patients = {
                new Patient(1, "Иванов", "Иван", "Иванович", "г. Москва", "327283", "123456", "Грипп"),
                new Patient(2, "Петров", "Петр", "Петрович", "г. Москва", "459267", "203559", "Грипп"),
                new Patient(3, "Иванов", "Николай", "Иванович", "г. Москва", "273829", "123453", "ОРВИ")
        };

        // Вывод пациентов с диагнозом "Грипп"
        System.out.println("Пациенты с диагнозом Грипп:");
        printPatientsWithDiagnosis(patients, "Грипп");

        // Вывод пациентов с номером медицинской карты в заданном интервале
        System.out.println("\nПациенты с номером медицинской карты от 123450 до 123459:");
        printPatientsByMedicalCardRange(patients, "123450", "123459");
    }
}
