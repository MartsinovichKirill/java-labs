package org.example;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private String clinicName;
    private List<Doctor> doctors;

    public Clinic(String clinicName) {
        this.clinicName = clinicName;
        this.doctors = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public Doctor findDoctorByName(String name) throws DoctorNotFoundException {
        for (Doctor doc : doctors) {
            if (doc.getName().equalsIgnoreCase(name)) {
                return doc;
            }
        }
        throw new DoctorNotFoundException("Врач с именем \"" + name + "\" не найден в клинике \"" + clinicName + "\".", name);
    }

    public void printDoctors() {
        System.out.println("Список врачей клиники \"" + clinicName + "\":");
        for (Doctor doc : doctors) {
            System.out.println("  " + doc);
        }
    }
}
