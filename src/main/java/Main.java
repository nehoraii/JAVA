import entities.*;
import jakarta.persistence.*;

//import jakarta.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("hdjfj");
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        try {
            transaction.begin();
            MyTableNameEntity dataEntity=new MyTableNameEntity();
            dataEntity.setFirstName("add of jpa");
            entityManager.persist(dataEntity);
            transaction.commit();
        }
        finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}