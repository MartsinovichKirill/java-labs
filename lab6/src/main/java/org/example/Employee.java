package org.example;

public class Employee {
    private String name;
    private Education education;

    public Employee(String name, Education education) {
        this.name = name;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public Education getEducation() {
        return education;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEducation(Education education) {
        this.education = education;
    }
}
