import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();

        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();



        //  Query query = session.createQuery("select Courses.id, Students.id from PurchaseList, Courses,Students where" +
//                " PurchaseList.courseName = Courses.name and  PurchaseList.studentName = Students.name ");

        Query query = session.createQuery("select s.id as studentId, c.id as courseId from PurchaseList as pl, Students as s, Courses as c where pl.studentName = s.name and pl.courseName = c.name ");

        List<Object[]> resultList = query.getResultList();



       resultList.forEach(element -> {

           Transaction transaction = session.beginTransaction();


           LinkedPurchaseListKey linkedPurchaseListKey = new LinkedPurchaseListKey();
           LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();


           linkedPurchaseListKey.setStudentId((Integer)element[0]);
           linkedPurchaseListKey.setCourseId((Integer)element[1]);


           linkedPurchaseList.setStudentId((Integer)element[0]);
           linkedPurchaseList.setCourseId((Integer)element[1]);
           linkedPurchaseList.setId(linkedPurchaseListKey);


           session.save(linkedPurchaseList);

           transaction.commit();


       });



        sessionFactory.close();

    }
}
