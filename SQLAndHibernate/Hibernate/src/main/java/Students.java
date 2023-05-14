import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class Students {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public int id;

    String name;
    int age;

    @Column(name = "registration_date")
    LocalDate registrationDate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
