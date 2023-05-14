import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Subscriptions {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    int id;

    @OneToOne (cascade = CascadeType.ALL)
    Students student;

    @OneToOne(cascade = CascadeType.ALL)
    Courses course;

    @Column(name = "subscription_date" )
    LocalDate subscriptionDate;

    public Students getStudent() {
        return student;
    }

    public Courses getCourse() {
        return course;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setStudent(Students studentID) {
        this.student = studentID;
    }

    public void setCourse(Courses courseId) {
        this.course = courseId;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
