import entities.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//import jakarta.*;
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();
        try {
            transaction.begin();
            MyTableNameEntity user = new MyTableNameEntity();
            user.setFirstName("Nehoraii1234567890");
            JPAFunction.Update(user,"zoisuefhgi");


//            TypedQuery<MyTableNameEntity> myTableName = entityManager.createNamedQuery("my_table_name", MyTableNameEntity.class);
//            myTableName.setParameter(1,"add of jpa");
//            for (MyTableNameEntity myTable:myTableName.getResultList()){
//                System.out.println(myTable);
//            }

//            Query query= entityManager.createNamedQuery("select");
//            List<MyTableNameEntity> list= query.getResultList();
//            for (MyTableNameEntity myTable : list){
//                System.out.println(myTable.toString());
//            }
//            TypedQuery<MyTableNameEntity> list = entityManager.createNamedQuery("select withe Condition",MyTableNameEntity.class);
//            list.setParameter(1,"add of jpa");
//            for(MyTableNameEntity e :list.getResultList()){
//                System.out.println(e);
//            }
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