package contacts;

import java.time.LocalDate;

public class Person extends Contact {
    private String surname;
    private LocalDate birthDate;
    private Gender gender;

    public Person(String name, String surname, String birthDate, String gender, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        setBirthDate(birthDate);
        setGender(gender);
        if (validatePhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "";
        }
        setCreated();
        setModified();
    }

    public void setSurname(String surname) {
        this.surname = surname;
        setModified();
    }

    public void setBirthDate(String birthDate) {
        if (birthDate != null) {
            try {
                this.birthDate = LocalDate.parse(birthDate);
            } catch (Exception DateTimeParseException) {
                System.out.println("Bad birth date!");
                this.birthDate = null;
            }
        }
        setModified();
    }

    public void setGender(String gender) {
        try {
            Gender g = Gender.valueOf(gender);
            this.gender = g;
        } catch (Exception IllegalArgumentException) {
            System.out.println("Bad gender!");
            this.gender = null;
        }
        setModified();
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

}
