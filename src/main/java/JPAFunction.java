import entities.MyTableNameEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.sql.ResultSet;

public class JPAFunction {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();

    public static void Insert(MyTableNameEntity user) {

        entityManager.persist(user);

    }
    public static void Update(MyTableNameEntity user,String Name){
        MyTableNameEntity person=entityManager.find(MyTableNameEntity.class,user.getId());
        person.setFirstName(Name);
        entityManager.merge(person);
    }

}
