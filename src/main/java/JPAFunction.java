import entities.MyTableNameEntity;
import jakarta.persistence.*;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JPAFunction {
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    static EntityTransaction transaction = entityManager.getTransaction();

    private static void UpConnection(){
        transaction.begin();
    }
    private static void DownConnection(){
        transaction.commit();
    }
    public static void Insert(String Name) {
        UpConnection();
        MyTableNameEntity user = new MyTableNameEntity();
        user.setFirstName(Name);
        entityManager.persist(user);
        DownConnection();

    }
    private static void UpdateQuery(MyTableNameEntity user,String Name){
        UpConnection();
        MyTableNameEntity person=entityManager.find(MyTableNameEntity.class,user.getId());
        person.setId(user.getId());
        person.setFirstName(Name);
        entityManager.merge(person);
        DownConnection();
    }
    public static void Update(String Name,String NameTo){
        MyTableNameEntity user = new MyTableNameEntity();
        user.setFirstName(Name);
        List<MyTableNameEntity> list=Select();
        for (int i = 0; i < list.size() ; i++) {
            if(list.get(i).getFirstName().equals(user.getFirstName())){
                UpdateQuery(list.get(i), NameTo);
            }
        }

    }
    public static List<MyTableNameEntity> Select(){
            UpConnection();
            TypedQuery<MyTableNameEntity> query=entityManager.createQuery("SELECT e FROM MyTableNameEntity e", MyTableNameEntity.class);
            List<MyTableNameEntity> listResult=query.getResultList();
            DownConnection();
            return listResult;
    }

}
