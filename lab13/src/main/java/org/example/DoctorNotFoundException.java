package org.example;

public class DoctorNotFoundException extends Exception {
    private String doctorName;

    public DoctorNotFoundException(String message, String doctorName) {
        super(message);
        this.doctorName = doctorName;
    }

    public String getDoctorName() {
        return doctorName;
    }
}
