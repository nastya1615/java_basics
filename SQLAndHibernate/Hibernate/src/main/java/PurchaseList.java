import jakarta.persistence.*;

import java.time.LocalDate;

@Entity


public class PurchaseList {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "student_name",length=500)
    String studentName;

    @Column(name = "course_name",length=500)
    String courseName;
    int price;

    @Column(name = "subscription_date")
    LocalDate subscriptionDate;

    public String getStudentName() {
        return studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
