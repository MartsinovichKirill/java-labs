package org.example;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialization;
    private int experience;
    private int rating;
    private List<String> patients;

    public Doctor(String name, String specialization, int experience, int rating) throws InvalidDoctorDataException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDoctorDataException("Имя врача не может быть пустым.");
        }
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new InvalidDoctorDataException("Специализация врача не может быть пустой.");
        }
        if (experience < 0) {
            throw new InvalidDoctorDataException("Опыт работы не может быть отрицательным: " + experience);
        }
        if (rating < 1 || rating > 5) {
            throw new InvalidDoctorDataException("Рейтинг должен быть в диапазоне от 1 до 5, получено: " + rating);
        }
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.rating = rating;
        this.patients = new ArrayList<>();
    }

    public void makeAppointment(String patient) throws AppointmentException {
        if (patient == null || patient.trim().isEmpty()) {
            throw new AppointmentException("Имя пациента не может быть пустым.");
        }
        if (patients.contains(patient)) {
            throw new AppointmentException("Пациент \"" + patient + "\" уже записан к врачу " + name + ".");
        }
        if (patients.size() >= 3) {
            throw new AppointmentException("У врача " + name + " нет свободных мест для записи (максимум 3 пациента).");
        }
        patients.add(patient);
        System.out.println("Пациент \"" + patient + "\" успешно записан к врачу " + name + " (" + specialization + ").");
    }

    public void updateRating(int newRating) throws InvalidDoctorDataException {
        if (newRating < 1 || newRating > 5) {
            throw new InvalidDoctorDataException("Некорректный новый рейтинг: " + newRating + " (допустимо от 1 до 5).");
        }
        this.rating = newRating;
        System.out.println("Рейтинг врача " + name + " обновлен до " + newRating + ".");
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }

    public int getRating() {
        return rating;
    }

    public List<String> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        return "Врач " + name + " [Специализация: " + specialization +
                ", Опыт: " + experience + " лет, Рейтинг: " + rating +
                ", Пациенты: " + patients + "]";
    }
}
