//Patient: id, Фамилия, Имя, Отчество, Адрес, Телефон, Номер медицинской карты,
// Диагноз. Создать массив объектов. Вывести: a) список пациентов, имеющих данный диагноз;
// b) список пациентов, номер медицинской карты у которых находится в заданном интервале.

import java.util.InputMismatchException;
import java.util.Scanner;

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
                   String address, String phone, String medicalCardNumber, String diagnosis) throws InvalidMedicalCardNumberException {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.phone = phone;
        setMedicalCardNumber(medicalCardNumber);
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

    public void setMedicalCardNumber(String medicalCardNumber) throws InvalidMedicalCardNumberException {
        if (!medicalCardNumber.matches("\\d{6}")) {
            throw new InvalidMedicalCardNumberException("Номер медицинской карты должен состоять из 6 цифр.");
        }
        this.medicalCardNumber = medicalCardNumber;
    }

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

    // Метод для ввода пациента с клавиатуры
    public static Patient inputPatient(Scanner scanner) throws InputDataException, InvalidMedicalCardNumberException {
        try {
            System.out.println("Введите ID:");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.println("Введите фамилию:");
            String lastName = scanner.nextLine();

            System.out.println("Введите имя:");
            String firstName = scanner.nextLine();

            System.out.println("Введите отчество:");
            String middleName = scanner.nextLine();

            System.out.println("Введите адрес:");
            String address = scanner.nextLine();

            System.out.println("Введите телефон:");
            String phone = scanner.nextLine();

            System.out.println("Введите номер медицинской карты (6 цифр):");
            String medicalCardNumber = scanner.nextLine();

            System.out.println("Введите диагноз:");
            String diagnosis = scanner.nextLine();

            return new Patient(id, lastName, firstName, middleName, address, phone, medicalCardNumber, diagnosis);
        } catch (InputMismatchException e) {
            throw new InputDataException("Некорректный ввод данных.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите количество пациентов:");
            int numPatients = scanner.nextInt();
            scanner.nextLine(); // consume newline

            Patient[] patients = new Patient[numPatients];
            for (int i = 0; i < numPatients; i++) {
                System.out.printf("Введите данные для пациента %d:\n", i + 1);
                patients[i] = inputPatient(scanner);
            }

            // Вывод пациентов с диагнозом "Грипп"
            System.out.println("Пациенты с диагнозом Грипп:");
            printPatientsWithDiagnosis(patients, "Грипп");

            // Вывод пациентов с номером медицинской карты в заданном интервале
            System.out.println("\nПациенты с номером медицинской карты от 123450 до 123459:");
            printPatientsByMedicalCardRange(patients, "123450", "123459");

        } catch (InputDataException | InvalidMedicalCardNumberException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
