import jakarta.persistence.*;
import org.dom4j.swing.XMLTableColumnDefinition;

import java.time.LocalDate;

@Entity
@Table(name = "Courses")

public class Courses {

   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY)
   int id;
   String name;
   int duration;

   @Enumerated(EnumType.STRING)
   @Column(columnDefinition = "enum('DESIGN','PROGRAMMING','MARKETING','MANAGMENT')")
   private CoursesType type;
   String description;

   @ManyToOne(cascade = CascadeType.ALL)
   Teachers teacher;
   @Column(name = "students_count")
   int studentsCount;
   int price;

   @Column(name = "price_per_hour")
   float pricePerHour;

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public int getDuration() {
      return duration;
   }

   public CoursesType getType() {
      return type;
   }

   public String getDescription() {
      return description;
   }

   public Teachers getTeacher() {
      return teacher;
   }

   public int studentsCount() {
      return studentsCount;
   }

   public int getPrice() {
      return price;
   }

   public float pricePerHour() {
      return pricePerHour;
   }

   public void setId(int id) {
      this.id = id;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setDuration(int duration) {
      this.duration = duration;
   }

   public void setType(CoursesType type) {
      this.type = type;
   }

   public void setDescription(String descripthion) {
      this.description = descripthion;
   }

   public void setTeacher(Teachers teacherId) {
      this.teacher = teacherId;
   }

   public void studentsCount(int students_count) {
      this.studentsCount = students_count;
   }

   public void setPrice(int price) {
      this.price = price;
   }

   public void pricePerHour(float price_per_hour) {
      this.pricePerHour = price_per_hour;
   }
}
