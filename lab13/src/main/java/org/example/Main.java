package org.example;

public class Main {
    public static void main(String[] args) {
        Clinic clinic = new Clinic("Здоровье Плюс");

        System.out.println("=== 1. Создание врачей и добавление в клинику ===");
        try {
            Doctor d1 = new Doctor("Иванов И.И.", "Кардиолог", 10, 5);
            Doctor d2 = new Doctor("Петрова А.С.", "Терапевт", 4, 4);
            Doctor d3 = new Doctor("Соколов М.В.", "Хирург", 15, 5);
            clinic.addDoctor(d1);
            clinic.addDoctor(d2);
            clinic.addDoctor(d3);

            // Попытка создать врача с некорректными данными (опыт < 0)
            Doctor invalidDoc = new Doctor("Ошибочный В.В.", "Окулист", -2, 5);
            clinic.addDoctor(invalidDoc);
        } catch (InvalidDoctorDataException e) {
            System.out.println("[Перехвачено InvalidDoctorDataException]: " + e.getMessage());
        }

        System.out.println();
        clinic.printDoctors();

        System.out.println("\n=== 2. Запись пациентов к врачу и обработка исключений ===");
        try {
            Doctor cardiologist = clinic.findDoctorByName("Иванов И.И.");
            cardiologist.makeAppointment("Алексеев П.П.");
            cardiologist.makeAppointment("Борисова М.К.");

            // Попытка повторной записи того же пациента
            cardiologist.makeAppointment("Алексеев П.П.");
        } catch (DoctorNotFoundException | AppointmentException e) {
            System.out.println("[Ошибка записи]: " + e.getMessage());
        }

        System.out.println("\n=== 3. Поиск несуществующего врача ===");
        try {
            Doctor unknown = clinic.findDoctorByName("Кузнецов Д.Д.");
            unknown.makeAppointment("Сидоров А.А.");
        } catch (DoctorNotFoundException e) {
            System.out.println("[Перехвачено DoctorNotFoundException]: " + e.getMessage() + " (Искали: " + e.getDoctorName() + ")");
        } catch (AppointmentException e) {
            System.out.println("[Перехвачено AppointmentException]: " + e.getMessage());
        }

        System.out.println("\n=== 4. Обновление рейтинга врача с блоком finally ===");
        try {
            Doctor therapist = clinic.findDoctorByName("Петрова А.С.");
            therapist.updateRating(5);
            // Попытка установить недопустимый рейтинг (6)
            therapist.updateRating(6);
        } catch (DoctorNotFoundException | InvalidDoctorDataException e) {
            System.out.println("[Ошибка обновления рейтинга]: " + e.getMessage());
        } finally {
            System.out.println("Блок finally: операции с клиникой завершены.");
        }

        System.out.println();
        clinic.printDoctors();
    }
}
